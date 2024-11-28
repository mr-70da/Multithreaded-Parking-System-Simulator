# Parking System Simulation Using Semaphores and Threads

## Overview
This project is a Java-based simulation of a parking system that uses semaphores and threads to handle concurrent car arrivals, parking, and departures across three gates. The program ensures thread synchronization to allocate parking spots effectively, handles race conditions, and provides detailed logging and status reports.

---

## Objectives
1. **Thread Synchronization:** Manage access to parking spots using semaphores.
2. **Concurrency Management:** Safeguard against race conditions during car arrivals and departures.
3. **Simulation Realism:** Reflect real-world timing for car arrivals and parking durations.
4. **Status Reporting:** Log activities and provide summary reports, including the total cars served and current parking status.

---

## System Specifications
- **Parking Spots:** 4 available spots.
- **Gates:** 3 gates (Gate 1, Gate 2, Gate 3).
- **Car Arrivals:** Scheduled as per an input file.
- **Concurrency Control:** Semaphores manage parking spot availability.
- **Logging:** Activities and parking status are logged in real-time.

---

## Tasks
### Functional Requirements
1. **Setup Parking Lot:** Initialize a parking lot with 4 spots.
2. **Gate Simulation:** Create threads for three gates, each handling car arrivals.
3. **Car Threads:** Represent each car with a thread attempting to acquire a parking spot.
4. **Synchronization:** Use semaphores to manage spot availability and ensure smooth operation.
5. **Logging and Reporting:** Log car activities and provide summary reports.

### Simulation Details
- **Arrival and Parking:** Use `Thread.sleep()` to simulate arrival times and parking durations.
- **Input Format:** Cars arrive as per a schedule provided in a `.txt` file.

#### Input Example
```
Gate 1, Car 0, Arrive 0, Parks 3
Gate 1, Car 1, Arrive 1, Parks 4
Gate 2, Car 5, Arrive 3, Parks 4
Gate 3, Car 10, Arrive 2, Parks 4
...
```

#### Expected Output Example
```
Car 0 from Gate 1 arrived at time 0
Car 0 from Gate 1 parked. (Parking Status: 1 spots occupied)
Car 1 from Gate 1 arrived at time 1
Car 1 from Gate 1 parked. (Parking Status: 2 spots occupied)
...
Total Cars Served: 15
Current Cars in Parking: 0
Details:
- Gate 1 served 5 cars.
- Gate 2 served 5 cars.
- Gate 3 served 5 cars.
```

---
