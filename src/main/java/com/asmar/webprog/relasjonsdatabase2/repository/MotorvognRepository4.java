package com.asmar.webprog.relasjonsdatabase2.repository;

import com.asmar.webprog.relasjonsdatabase2.model.Bil;
import com.asmar.webprog.relasjonsdatabase2.model.Motorvogn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MotorvognRepository4 {
    @Autowired
    private JdbcTemplate db;

    public void lagreMotorvogn2(Motorvogn innMotorvogn) {
        String query = "INSERT INTO Motorvogn4 (personNr,navn,adresse,kjennetegn,merke,type) VALUES(?,?,?,?,?,?)";
        db.update(query,innMotorvogn.getPersonNr(), innMotorvogn.getNavn(), innMotorvogn.getAdresse(), innMotorvogn.getKjennetegn(),
                innMotorvogn.getMerke(), innMotorvogn.getType());
    }

    public List<Motorvogn> hentAlleMotorvogner() {
        String query = "SELECT * FROM Motorvogn4";
        List<Motorvogn> alleMotorvogner = db.query(query, new BeanPropertyRowMapper(Motorvogn.class));

        return alleMotorvogner;
    }

    public boolean slettAlleMotorvogner() {
        String query = "DELETE FROM Motorvogn4";
        if(hentAlleMotorvogner().isEmpty()) {
            return false;
        }
        else {
            db.update(query);
            return true;
        }
    }

    public void slettEnMotorvogn(int id) {
        String query = "DELETE FROM Motorvogn4 WHERE id=?";
        db.update(query,id);
    }

    public List<Bil> hentBiler() {
        String query = "SELECT * FROM Bil4";
        List<Bil> alleBiler = db.query(query, new BeanPropertyRowMapper(Bil.class));
        return alleBiler;
    }
}
