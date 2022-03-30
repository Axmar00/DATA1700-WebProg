package com.asmar.webprog.relasjonsdatabase1.repository;

import com.asmar.webprog.relasjonsdatabase1.model.Bil;
import com.asmar.webprog.relasjonsdatabase1.model.Motorvogn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MotorvognRepository3 {
    @Autowired
    private JdbcTemplate db;

    public void lagreMotorvogn2(Motorvogn innMotorvogn) {
        String query = "INSERT INTO Motorvogn (personNr,navn,adresse,kjennetegn,merke,type) VALUES(?,?,?,?,?,?)";
        db.update(query,innMotorvogn.getPersonNr(), innMotorvogn.getNavn(), innMotorvogn.getAdresse(), innMotorvogn.getKjennetegn(),
                innMotorvogn.getMerke(), innMotorvogn.getType());
    }

    public List<Motorvogn> hentAlleMotorvogner() {
        String query = "SELECT * FROM Motorvogn";
        List<Motorvogn> alleMotorvogner = db.query(query, new BeanPropertyRowMapper(Motorvogn.class));

        return alleMotorvogner;
    }

    public boolean slettAlleMotorvogner() {
        String query = "DELETE FROM Motorvogn";
        if(hentAlleMotorvogner().isEmpty()) {
            return false;
        }
        else {
            db.update(query);
            return true;
        }
    }

    public void slettEnMotorvogn(int id) {
        String query = "DELETE FROM Motorvogn WHERE id=?";
        db.update(query,id);
    }

    public List<Bil> hentAlleBiler() {
        String query = "SELECT * FROM Bil";
        List<Bil> alleBiler = db.query(query, new BeanPropertyRowMapper(Bil.class));
        return alleBiler;
    }
}
