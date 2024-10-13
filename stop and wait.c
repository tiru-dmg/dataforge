#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <unistd.h>  // for sleep function
#include <time.h>    // for rand()
#define TIMEOUT 1
#define MAX_ATTEMPTS 3
bool transmit_data(int data) {
    sleep(rand() % 3);
    if ((rand() % 100) < 95) {
        printf("Data %d received\n", data);
        return true;}
    return false;}
void send_data(int data_buffer[], int size) {
	int i;
    for ( i = 0; i < size; i++) {
        int data = data_buffer[i];
        printf("Transmitting data %d\n", data);       
        int attempts = 0;
        while (attempts < MAX_ATTEMPTS) {
            bool success = transmit_data(data);
            if (success) {
                printf("ACK received for data %d\n", data);
                printf("Transmitted data %d successfully\n", data);
                break;
            } else {
                printf("NACK received for data %d, retrying transfer\n", data);
                attempts++;
                if (attempts == MAX_ATTEMPTS) {
                    printf("Failed to transmit data %d after %d attempts\n", data, MAX_ATTEMPTS);}}}}}
int main() {
    srand(time(0));
    int data[] = {1, 2, 3, 4};
    int size = sizeof(data) / sizeof(data[0]);
    send_data(data, size);
    return 0;
}
