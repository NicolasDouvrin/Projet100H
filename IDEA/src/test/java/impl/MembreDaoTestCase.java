package impl;

import devweb.dao.MembreDao;
import devweb.dao.impl.DataSourceProvider;
import devweb.dao.impl.MembreDaoImpl;
import devweb.entities.Membre;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

public class MembreDaoTestCase {

    private MembreDao membreDao = new MembreDaoImpl();

    @Before
    public void initDb() throws Exception {
        try (Connection connection = DataSourceProvider.getDataSource().getConnection();
             Statement stmt = connection.createStatement()) {
            stmt.executeUpdate("DELETE FROM membre");
            stmt.executeUpdate("INSERT INTO `membre`(`email`,`nom`,`prenom`,`classe`,`mdp`) VALUES ('jp@hei.fr','Boulon','Jacques','H44','123')");
            stmt.executeUpdate("INSERT INTO `membre`(`email`,`nom`,`prenom`,`classe`,`mdp`) VALUES ('michel@hei.fr','Pastel','Richard','H55','voldemort')");
            stmt.executeUpdate("INSERT INTO `membre`(`email`,`nom`,`prenom`,`classe`,`mdp`) VALUES ('jc@hei.fr','Blanc','Michel','H32','vis')");

        }
    }

    @Test
    public void shouldListMembres() {
        // WHEN
        List<Membre> membres = membreDao.listMembres();
        // THEN
        assertThat(membres).hasSize(3);
        assertThat(membres).extracting("email", "nom").containsOnly(tuple("jc@hei.fr", "Blanc"), tuple("michel@hei.fr", "Pastel"),
                tuple("jp@hei.fr", "Boulon"));
    }

    @Test
    public void shouldGetMembre() {
        // WHEN
        Membre membre = membreDao.getMembre("jp@hei.fr");
        // THEN
        assertThat(membre).isNotNull();
        assertThat(membre.getEmail()).isEqualTo("jp@hei.fr");
        assertThat(membre.getNom()).isEqualTo("Boulon");
        assertThat(membre.getPrenom()).isEqualTo("Jacques");
        assertThat(membre.getClasse()).isEqualTo("H44");
        assertThat(membre.getMdp()).isEqualTo("123");
    }

    @Test
    public void shouldNotGetUnknownMembre() {
        // WHEN
        Membre membre = membreDao.getMembre("-jp@hei.fr");
        // THEN
        assertThat(membre).isNull();
    }

    @Test
    public void shouldAddMembre() throws Exception {
        // WHEN
        membreDao.addMembre("test","test","test","test","test");
        // THEN
        try (Connection connection = DataSourceProvider.getDataSource().getConnection();
             Statement stmt = connection.createStatement()) {
            try (ResultSet rs = stmt.executeQuery("SELECT * FROM membre WHERE email='test' AND nom = 'test' AND prenom='test' AND classe='test' AND mdp='test'")) {
                assertThat(rs.next()).isTrue();
                assertThat(rs.getString("email")).isEqualTo("test");
                assertThat(rs.getString("nom")).isEqualTo("test");
                assertThat(rs.getString("prenom")).isEqualTo("test");
                assertThat(rs.getString("classe")).isEqualTo("test");
                assertThat(rs.getString("mdp")).isEqualTo("test");
                assertThat(rs.next()).isFalse();
            }
        }
    }
}
