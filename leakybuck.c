#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>  
#define MAX_BUCKET_SIZE 32  
#define PACKET_SEND_RATE 1  
void leaky_bucket(int incoming_size, int *current_level) {
    if (incoming_size + *current_level > MAX_BUCKET_SIZE) {
        printf("Packet of size %d discarded (overflow).\n", incoming_size);
    } else {
        *current_level += incoming_size;
        printf("Packet of size %d added. Current bucket level: %d\n", incoming_size, *current_level);}
    if (*current_level > 0) {
        *current_level -= PACKET_SEND_RATE;
        printf("Sent 1 packet. Bucket level now: %d\n", *current_level);
    } else {
        printf("Bucket is empty, no packet sent.\n");}}
int main() {
    int current_level = 0;  
    int packet_size, i;
    int wait_time = 1; 
    int packet_sizes[] = {2, 13, 14, 6};
    int total_packets = sizeof(packet_sizes) / sizeof(packet_sizes[0]);
    for (i = 0; i < total_packets; i++) {
        packet_size = packet_sizes[i];   
        printf("\nNew incoming packet of size: %d\n", packet_size);
        leaky_bucket(packet_size, &current_level);
        sleep(wait_time);  }
    return 0;}
 
