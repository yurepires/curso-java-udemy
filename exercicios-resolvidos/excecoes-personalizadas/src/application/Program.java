package application;

import model.entities.Reservation;
import model.exceptions.DomainException;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try {
            System.out.print("Room number: ");
            int number = sc.nextInt();
            System.out.print("Check-in date (DD/MM/YYYY): ");
            LocalDate checkIn = LocalDate.parse(sc.next(), fmt);
            System.out.print("Check-out date (DD/MM/YYYY): ");
            LocalDate checkOut = LocalDate.parse(sc.next(), fmt);

            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);

            System.out.println();
            System.out.println("Enter data to update the reservation: ");
            System.out.print("Chek-in date (DD/MM/YYYY): ");
            checkIn = LocalDate.parse(sc.next(), fmt);
            System.out.print("Chek-out date (DD/MM/YYYY): ");
            checkOut = LocalDate.parse(sc.next(), fmt);

            reservation.updateDates(checkIn, checkOut);
            System.out.println("Reservation: " + reservation);
        } catch (DomainException e){ // ou IllegalArgumentsException
            System.out.println("Error in reservation: " + e.getMessage());
        } catch (DateTimeParseException e){
            System.out.println("Invalid date format");
        } catch (RuntimeException e) {
            System.out.println("Unexpected error");
        }
        // 23/09/2025
        // 26/09/2025
        // 24/09/2025
        // 29/09/2024

        sc.close();
    }
}
