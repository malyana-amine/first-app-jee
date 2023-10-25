package com.example.first_app_jee.Dao.Equiupment;


import com.example.first_app_jee.Entities.Equipment;
import com.example.first_app_jee.Entities.EquipmentStatus;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;
import java.util.List;

import static org.junit.Assert.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class EquipmentDaoImpTest {

    private static EntityManagerFactory emf;
    private EquipmentDao equipmentDao;

    @BeforeAll
    static void setUp() {
        emf = Persistence.createEntityManagerFactory("default");
    }

    @BeforeEach
    void init() {
        equipmentDao = new EquipmentDaoImp();
    }

    @Test
    void testAddEquipment() {
        int sizeBefore = equipmentDao.getAllEquipment().size();
        Equipment equipment = new Equipment(); // Create a test Equipment object
        equipment.setName("Test Equipment");
        equipment.setReserved(true);
        equipment.setStatus(EquipmentStatus.Disponible);
        equipmentDao.add(equipment);
        int sizeAfter = equipmentDao.getAllEquipment().size();


        assertEquals(sizeAfter, sizeBefore + 1);

    }

    @Test
    void testGetAllEquipment() {
        List<Equipment> equipmentList = equipmentDao.getAllEquipment();
        // Assert that the list is not null and not empty
        Assertions.assertNotNull(equipmentList);
        Assertions.assertFalse(equipmentList.isEmpty());
    }

    @Test
    void testGetEquipmentById() {
        Equipment equipment = new Equipment();
        equipment.setName("Test Equipment");

        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(equipment);
        entityManager.getTransaction().commit();
        entityManager.close();

        // Retrieve the equipment by its ID
        Equipment retrievedEquipment = equipmentDao.getEquipmentById(19);

        Assertions.assertNotNull(retrievedEquipment);
        Assertions.assertEquals(equipment.getName(), retrievedEquipment.getName());
        // Compare other attributes as needed
    }


    @Test
    void testDeleteEquipment() {
        Equipment equipment = new Equipment();
        equipment.setName("Test Equipment");

        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(equipment);
        entityManager.getTransaction().commit();
        entityManager.close();

        equipmentDao.deleteEquipment(Math.toIntExact(equipment.getId()));

        Equipment deletedEquipment = emf.createEntityManager().find(Equipment.class, equipment.getId());
        Assertions.assertNull(deletedEquipment);
    }

    @AfterAll
    static void tearDown() {
        if (emf != null) {
            emf.close();
        }
    }
}
