package com.ticket.booking.Ticket.Booking.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ticket.booking.Ticket.Booking.Entity.User;
import com.ticket.booking.Ticket.Booking.Util.UserServiceUtil;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

public class UserBookingService {

    private User user;
    private List<User> userList;
    private ObjectMapper objectMapper = new ObjectMapper();
    private static final String USERS_PATH = "src/main/java/com/ticket/booking/Ticket/Booking/localDb/users.json";

    public UserBookingService(User user1) throws IOException {
        this.user=user1;
        loadUsers();
}
    public UserBookingService() throws IOException {
        loadUsers();
    }

    public List<User> loadUsers() throws IOException{
        File users = new File(USERS_PATH);
        return objectMapper.readValue(users, new TypeReference<List<User>>() {});
    }
    public Boolean loginUser(){
        Optional<User> foundUser = userList.stream()
                .filter(user1 -> {
                    return user1.getName().equals(user.getName()) && UserServiceUtil.checkPassword(user.getPassword(),
                    user1.getHashedPassword());
                })
                .findFirst();
               return foundUser.isPresent();
                }
    public Boolean signUp(User user1){
        try{
            userList.add(user1);
            saveUserListToFile();
            return Boolean.TRUE;
        }
        catch (IOException ex){
            return  Boolean.FALSE;
        }
    }

    private void saveUserListToFile() throws IOException{
        File usersFile = new File(USERS_PATH);
        objectMapper.writeValue(usersFile, userList);
    }
    //json  ----> object (User) ---> Deserialize
    //Object (User) --->json ----> Serialize

    public void fetchBooking(){
        user.printTickets();
    }
    public Boolean cancelBooking(String ticketId){
        return Boolean.FALSE;
    }
}
