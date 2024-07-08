/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modal;

import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author MISS NGA
 */
public class Bill {
    private int id;
    private LocalDateTime createdDateTime;
    private String total;
    private List<Tickets> tickets;
    private Users user;
    public Bill() {
    }

    public Bill(int id, LocalDateTime createdDateTime, String total, List<Tickets> tickets, Users user) {
        this.id = id;
        this.createdDateTime = createdDateTime;
        this.total = total;
        this.tickets = tickets;
        this.user = user;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(LocalDateTime createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public List<Tickets> getTickets() {
        return tickets;
    }

    public void setTickets(List<Tickets> tickets) {
        this.tickets = tickets;
    }

    

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
    
    
}
