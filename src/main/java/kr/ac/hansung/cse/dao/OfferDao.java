package kr.ac.hansung.cse.dao;

import kr.ac.hansung.cse.model.Offer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class OfferDao {

    private JdbcTemplate jdbcTemplate;  // psa(portable service abstraction, sql(x) api

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public int getRowCount() {
        String sqlStatement= "select count(*) from courses";
        return jdbcTemplate.queryForObject(sqlStatement, Integer.class);

    }
    //query and return a single object
    public Offer getOffer(String name) {

        String sqlStatement= "select * from courses where name=?";
        return jdbcTemplate.queryForObject(sqlStatement, new Object[] {name},
                new RowMapper<Offer>() {

                    @Override
                    public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {

                        Offer offer= new Offer();

                        offer.setYear(rs.getInt("수강년도"));
                        offer.setSemester(rs.getInt("학기"));
                        offer.setSubject_code(rs.getString("교과코드"));
                        offer.setSubject_name(rs.getString("과목명"));
                        offer.setSubject_classification(rs.getString("교과구분"));
                        offer.setProfessor(rs.getString("담당교수"));
                        offer.setGrades(rs.getInt("학점"));

                        return offer;
                    }
                });
    }

    //query and return multiple objects
    // cRud method
    public List<Offer> getOffers() {

        String sqlStatement= "select * from courses";
        return jdbcTemplate.query(sqlStatement, new RowMapper<Offer>() {

            @Override
            public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {

                Offer offer= new Offer();

                offer.setYear(rs.getInt("수강년도"));
                offer.setSemester(rs.getInt("학기"));
                offer.setSubject_code(rs.getString("교과코드"));
                offer.setSubject_name(rs.getString("과목명"));
                offer.setSubject_classification(rs.getString("교과구분"));
                offer.setProfessor(rs.getString("담당교수"));
                offer.setGrades(rs.getInt("학점"));

                return offer;
            }
        });
    }


    // Crud method
    public boolean insert(Offer offer) {
        int year = offer.getYear();
        int semester = offer.getSemester();
        String subject_code = offer.getSubject_code();
        String Subject_name = offer.getSubject_name();
        String Subject_classification = offer.getSubject_classification();
        String Professor = offer.getProfessor();
        int Grades = offer.getGrades();

        String sqlStatement= "insert into courses" +
                "(수강년도, 학기, 교과코드, 과목명," +
                "교과구분, 담당교수, 학점) values (?,?,?,?,?,?,?)";

        return (jdbcTemplate.update(sqlStatement,
                new Object[] {year, semester, subject_code, Subject_name, Subject_classification, Professor, Grades}) == 1);
    }

    // crUd method
    public boolean update(Offer offer) {

        int Year = offer.getYear();
        int Semester = offer.getSemester();
        String Subject_code = offer.getSubject_code();
        String Subject_name = offer.getSubject_name();
        String Subject_classification = offer.getSubject_classification();
        String Professor = offer.getProfessor();
        int Grades = offer.getGrades();

        String sqlStatement=
                "update courses set Year=?, Semester=?, Subject_code=?," +
                        "Subject_name = ?, Subject_classification = ?," +
                        "Professor = ?, Grades = ? where id=?";

        return (jdbcTemplate.update(sqlStatement,
                new Object[] {Year, Semester, Subject_code, Subject_name, Subject_classification, Professor, Grades}) == 1);
    }

    //cruD method
    public boolean delete(int id) {
        String sqlStatement= "delete from courses where id=?";
        return (jdbcTemplate.update(sqlStatement, new Object[] {id}) == 1);
    }


}
