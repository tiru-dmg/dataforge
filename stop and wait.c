#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <unistd.h>  // for usleep
#include <time.h>
 
// Function to simulate sending a packet
bool send_packet(int packet) {
    usleep((rand() % 2 + 1) * 1000000);  // Random delay of 1 to 2 seconds
    if ((rand() % 100) < 90) {
        printf("Packet %d sent successfully.\n", packet);
        return true;  // Packet sent successfully
    }
    return false;  // Packet sending failed
}
 
// Function to simulate receiving acknowledgment
bool get_ack(int packet) {
    usleep((rand() % 2 + 1) * 1000000);  // Random delay of 1 to 2 seconds
    if ((rand() % 100) < 80) {
        printf("ACK received for packet %d.\n", packet);
        return true;  // Acknowledgment received
    } else {
        printf("NACK or Timeout for packet %d.\n", packet);
        return false;  // No acknowledgment received
    }
}
 
int main() {
    srand(time(NULL));  // Set seed for random number generation
    int num_packets, i;
 
    // Ask user for the number of packets
    printf("Enter the number of packets to send: ");
    scanf("%d", &num_packets);
 
    // Create an array to hold the packet numbers
    int *packets = (int *)malloc(num_packets * sizeof(int));
 
    // Get packet numbers from the user
    printf("Enter the packet numbers (integers):\n");
    for (i = 0; i < num_packets; i++) {
        printf("Packet %d: ", i + 1);
        scanf("%d", &packets[i]);
    }
 
    // Send each packet and wait for acknowledgment
    for (i = 0; i < num_packets; i++) {
        bool ack_received = false;  // Acknowledgment not received yet
        while (!ack_received) {
            printf("Sending packet %d...\n", packets[i]);
            bool send_success = send_packet(packets[i]);  // Try to send packet
            if (send_success) {
                ack_received = get_ack(packets[i]);  // Wait for ACK
                if (!ack_received) {
                    printf("Resending packet %d due to NACK or Timeout.\n", packets[i]);
                }
            } else {
                printf("Packet %d sending failed, trying again...\n", packets[i]);
            }
        }
    }
 
    printf("All packets sent successfully using Stop-and-Wait ARQ.\n");
 
    // Free the memory allocated for packets
    free(packets);
    return 0;
}
