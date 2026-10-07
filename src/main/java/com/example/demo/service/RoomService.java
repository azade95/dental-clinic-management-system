package com.example.demo.service;

import com.example.demo.entity.Room;
import com.example.demo.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public Room getRoomById(Long id) {
        return roomRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "Room not found with id: " + id
                ));
    }

    public Room createRoom(Room room) {
        return roomRepository.save(room);
    }

    public Room updateRoom(Long id, Room room) {
        Room existingRoom = roomRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "Room not found with id: " + id
                ));

        existingRoom.setName(room.getName());
        existingRoom.setDescription(room.getDescription());
        existingRoom.setActive(room.getActive());

        return roomRepository.save(existingRoom);
    }

    public void deleteRoom(Long id) {
        Room room = roomRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "Room not found with id: " + id
                ));

        roomRepository.delete(room);
    }
}
