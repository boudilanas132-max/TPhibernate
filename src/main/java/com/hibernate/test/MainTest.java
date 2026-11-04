
package com.hibernate.test;

import com.hibernate.entities.Machine;
import com.hibernate.entities.Salle;
import com.hibernate.services.MachineService;
import com.hibernate.services.SalleService;

public class MainTest {

    public static void main(String[] args) {

        SalleService salleService = new SalleService();
        MachineService machineService = new MachineService();

        // Création d'une salle
        Salle salleA = new Salle();
        salleA.setCode("S1");
        salleA.setLibelle("Salle Informatique");

        salleService.create(salleA);

        // Création d'une machine
        Machine machine = new Machine();
        machine.setRef("M-101");
        machine.setMarque("Dell");
        machine.setSalle(salleA);

        machineService.create(machine);

        System.out.println("Données insérées avec succès !");
    }
}
