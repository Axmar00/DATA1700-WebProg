package com.asmar.webprog.relasjonsdatabase2.repository;

import com.asmar.webprog.relasjonsdatabase2.model.Bil;
import com.asmar.webprog.relasjonsdatabase2.model.Motorvogn;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MotorvognRepository4 {
    @Autowired
    private JdbcTemplate db;

    private Logger logger = LoggerFactory.getLogger(MotorvognRepository4.class);

    public boolean lagreMotorvogn(Motorvogn innMotorvogn) {
        String query = "INSERT INTO Motorvogn4 (personNr,navn,adresse,kjennetegn,merke,type) VALUES(?,?,?,?,?,?)";
        try {
            db.update(query, innMotorvogn.getPersonNr(), innMotorvogn.getNavn(), innMotorvogn.getAdresse(), innMotorvogn.getKjennetegn(),
                    innMotorvogn.getMerke(), innMotorvogn.getType());
            return true;
        } catch(Exception e) {
            logger.error("Feil i lagreMotorvogn(): " + e);
            return false;
        }
    }

    public List<Motorvogn> hentAlleMotorvogner() {
        String query = "SELECT * FROM Motorvogn4";
        List<Motorvogn> alleMotorvogner = db.query(query, new BeanPropertyRowMapper(Motorvogn.class));

        return alleMotorvogner;
    }

    public void slettAlleMotorvogner() {
        String query = "DELETE FROM Motorvogn4";
        db.update(query);
    }

    public void slettEnMotorvogn(int id) {
        String query = "DELETE FROM Motorvogn4 WHERE id=?";
        db.update(query,id);
    }

    public Motorvogn hentEnMotorvogn(int id) {
        Object[] param = new Object[1];
        param[0] = id;
        String query = "SELECT * FROM Motorvogn4 WHERE id=?";
        Motorvogn motorvogn = db.queryForObject(query, param, BeanPropertyRowMapper.newInstance(Motorvogn.class));
        return motorvogn;
    }

    public void endreMotorvogn(Motorvogn innMotorvogn) {
        String query = "UPDATE Motorvogn SET personNr=?,navn=?,adresse=?,kjennetegn=?,merke=?,type=?";
        db.update(query, innMotorvogn.getPersonNr(),innMotorvogn.getNavn(),
                innMotorvogn.getAdresse(),innMotorvogn.getKjennetegn(),innMotorvogn.getMerke(),innMotorvogn.getType());
    }

    public List<Bil> hentBiler() {
        String query = "SELECT * FROM Bil4";
        List<Bil> alleBiler = db.query(query, new BeanPropertyRowMapper(Bil.class));
        return alleBiler;
    }
}
