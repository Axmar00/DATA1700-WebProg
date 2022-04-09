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
        try {
            return db.query(query, new BeanPropertyRowMapper(Motorvogn.class));
        } catch(Exception e) {
            logger.error("Feil i hentAlleMotorvogner(): " + e);
            return null;
        }
    }

    public boolean slettAlleMotorvogner() {
        String query = "DELETE FROM Motorvogn4";
        try {
            db.update(query);
            return true;
        } catch(Exception e) {
            logger.error("Feil i slettAlleMotorvogner(): " + e);
            return false;
        }
    }

    public boolean slettEnMotorvogn(int id) {
        String query = "DELETE FROM Motorvogn4 WHERE id=?";
        try {
            db.update(query, id);
            return true;
        } catch(Exception e) {
            logger.error("Feil i slettEnMotorvogn(): " + e);
            return false;
        }
    }

    public Motorvogn hentEnMotorvogn(int id) {
        Object[] param = new Object[1];
        param[0] = id;
        String query = "SELECT * FROM Motorvogn4 WHERE id=?";
        try {
            return db.queryForObject(query, param, BeanPropertyRowMapper.newInstance(Motorvogn.class));
        } catch(Exception e) {
            logger.error("Feil i hentEnMotorvogn(): " + e);
            return null;
        }
    }

    public boolean endreMotorvogn(Motorvogn m) {
        String query = "UPDATE Motorvogn4 SET personNr=?,navn=?,adresse=?,kjennetegn=?,merke=?,type=? where id=?";
        try {
            db.update(query, m.getPersonNr(), m.getNavn(), m.getAdresse(), m.getKjennetegn(), m.getMerke(),
                    m.getType(), m.getId());
            return true;
        } catch(Exception e) {
            logger.error("Feil i endreMotorvogn(): " + e);
            return false;
        }
    }

    public List<Bil> hentBiler() {
        String query = "SELECT * FROM Bil4";
        try {
            return db.query(query, new BeanPropertyRowMapper(Bil.class));
        } catch(Exception e) {
            logger.error("Feil i hentBiler(): " + e);
            return null;
        }
    }
}