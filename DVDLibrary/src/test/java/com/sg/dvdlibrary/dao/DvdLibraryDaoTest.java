/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.dto.Dvd;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author capta
 */
public class DvdLibraryDaoTest {

    private DvdLibraryDao dao = new DvdLibraryDaoFileImpl();

    public DvdLibraryDaoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws Exception {
        List<Dvd> dvdList = dao.getAllDvds();
        for (Dvd dvd : dvdList) {
            dao.removeDvd(dvd.getTitle());
        }
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of addDvd method, of class DvdLibraryDao.
     */
    @Test
    public void testAddGetDvd() throws Exception {
        Dvd dvd = new Dvd("One");
        dvd.setReleaseDate("2018");
        dvd.setMpaaRating("R");
        dvd.setDirectorsName("Tim");
        dvd.setStudio("Disney");
        dvd.setNote("Cool film");

        dao.addDvd(dvd.getTitle(), dvd);

        Dvd fromDao = dao.getDvd(dvd.getTitle());
        assertEquals(dvd, fromDao);
    }

    /**
     * Test of getAllDvds method, of class DvdLibraryDao.
     */
    @Test
    public void testGetAllDvds() throws Exception {
        Dvd dvd1 = new Dvd("One");
        dvd1.setReleaseDate("2018");
        dvd1.setMpaaRating("R");
        dvd1.setDirectorsName("Tim");
        dvd1.setStudio("Disney");
        dvd1.setNote("Cool film");

        dao.addDvd(dvd1.getTitle(), dvd1);

        Dvd dvd2 = new Dvd("Two");
        dvd2.setReleaseDate("2019");
        dvd2.setMpaaRating("PG-13");
        dvd2.setDirectorsName("Arya");
        dvd2.setStudio("Lucas Film");
        dvd2.setNote("Cooler film");

        dao.addDvd(dvd2.getTitle(), dvd2);

        assertEquals(2, dao.getAllDvds().size());
    }

    /**
     * Test of removeDvd method, of class DvdLibraryDao.
     */
    @Test
    public void testRemoveDvd() throws Exception {
        Dvd dvd1 = new Dvd("One");
        dvd1.setReleaseDate("2018");
        dvd1.setMpaaRating("R");
        dvd1.setDirectorsName("Tim");
        dvd1.setStudio("Disney");
        dvd1.setNote("Cool film");

        dao.addDvd(dvd1.getTitle(), dvd1);

        Dvd dvd2 = new Dvd("Two");
        dvd2.setReleaseDate("2019");
        dvd2.setMpaaRating("PG-13");
        dvd2.setDirectorsName("Arya");
        dvd2.setStudio("Lucas Film");
        dvd2.setNote("Cooler film");

        dao.addDvd(dvd2.getTitle(), dvd2);

        dao.removeDvd(dvd1.getTitle());
        assertEquals(1, dao.getAllDvds().size());
        assertNull(dao.getDvd(dvd1.getTitle()));
        
        dao.removeDvd(dvd2.getTitle());
        assertEquals(0, dao.getAllDvds().size());
        assertNull(dao.getDvd(dvd2.getTitle()));
        
    }

}
