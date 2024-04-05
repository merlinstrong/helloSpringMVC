package kr.ac.hansung.cse.controller;

import kr.ac.hansung.cse.model.Offer;
import kr.ac.hansung.cse.model.SemesterCredits;
import kr.ac.hansung.cse.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.*;

@Controller
public class OfferController {

    // Controller -> Service -> Dao
    @Autowired
    private OfferService offerService;

    @GetMapping("/offers")
    public String showOffers(Model model) {
        List<Offer> offers = offerService.getAllOffers();

        List<SemesterCredits> semesterCredits = new ArrayList<>();


        Map<Integer, int[]> totalSemesterCredits = new HashMap<>();
        totalSemesterCredits.put(2016, new int[]{0, 0});
        totalSemesterCredits.put(2017, new int[]{0, 0});
        totalSemesterCredits.put(2018, new int[]{0, 0});
        totalSemesterCredits.put(2022, new int[]{0, 0});

        for (Offer offer : offers) {
            int year = offer.getYear();
            int semester = offer.getSemester() - 1;
            int grades = offer.getGrades();

            int[] credits = totalSemesterCredits.get(year);
            if (credits != null) {
                credits[semester] += grades;
            }
        }
        // 학점 총합을 저장할 변수를 초기화합니다.
        int totalCreditsSum = 0;

        // totalSemesterCredits 맵을 순회합니다.
        for (Map.Entry<Integer, int[]> entry : totalSemesterCredits.entrySet()) {
            int year = entry.getKey();
            int[] creditsArray = entry.getValue();

            // 1학기와 2학기에 대해서 반복하여 SemesterCredits 객체를 생성하고 리스트에 추가합니다.
            for (int semester = 1; semester <= creditsArray.length; semester++) {
                int totalCredits = creditsArray[semester - 1];

                // 학점 총합에 현재 학점을 더합니다.
                totalCreditsSum += totalCredits;

                // 총학점이 0인 경우, 리스트에 추가하지 않습니다.
                if (totalCredits > 0) {
                    SemesterCredits sc = new SemesterCredits();
                    sc.setYear(String.valueOf(year));
                    sc.setSemester(semester);
                    sc.setTotalSemesterCredits(totalCredits);
                    // details 필드는 여기서는 설정하지 않았습니다. 필요한 경우 추가 정보를 설정할 수 있습니다.

                    // 생성된 SemesterCredits 객체를 리스트에 추가합니다.
                    semesterCredits.add(sc);
                }
            }
        }
        SemesterCredits sc_end = new SemesterCredits();


        sc_end.setYear("총계");
        sc_end.setTotalSemesterCredits(totalCreditsSum);

        // 리스트의 마지막에 sc_end 객체 추가
        semesterCredits.add(sc_end);

        model.addAttribute("id_semesterCredits", semesterCredits);


        return "offers";
    }

    @GetMapping("/details")
    public String getDetails(@RequestParam("year") int year,
                             @RequestParam("semester") int semester, Model model) {

        List<Offer> offers = offerService.getAllOffers();
        List<Offer> filteredOffers = new ArrayList<>();

        for (Offer offer : offers) {
            if (offer.getYear() == year && offer.getSemester() == semester) {
                filteredOffers.add(offer);
            }
        }

        model.addAttribute("id_offer", filteredOffers);

        // 반환하는 뷰 이름을 보다 동적으로 설정하거나, 하나의 뷰를 고정적으로 사용할 수 있습니다.
        // 예시에서는 단순화를 위해 하나의 뷰 이름을 사용합니다.
        return "details"; // detailsView.jsp 또는 다른 뷰 템플릿 파일명
    }

    @GetMapping("/createoffer")
    public String createOffer(Model model) {

        model.addAttribute("offer", new Offer());

        return "createoffer";
    }

    @PostMapping("/docreate")
    public String doCreate(Model model, @Valid Offer offer, BindingResult result) {


        if(result.hasErrors()) {
            System.out.println("== Form data does not validated ==");

            List<ObjectError> errors = result.getAllErrors();

            for(ObjectError error:errors) {
                System.out.println(error.getDefaultMessage());
            }

            return "createoffer";
        }
        offer.setYear(2024);
        offer.setSemester(2);
        offer.setSubject_code("미정");

        // Controller -> Service -> Dao
         offerService.insert(offer);

        return "offercreated";
    }
}
