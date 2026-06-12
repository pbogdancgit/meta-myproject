#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <unistd.h>
#include <string.h>

#define DEVICE_PATH "/dev/my1st"

int main() {
    int fd;
    char buffer[256];
    
    printf("[User-Space] Incercam sa comunicam cu driverul...\n");
    
    fd = open(DEVICE_PATH, O_RDWR);
    if (fd < 0) {
        perror("[User-Space] Eroare la deschiderea /dev/my1st");
        return 1;
    }
    
    // Citim ce trimite driverul la probe/initializare
    memset(buffer, 0, sizeof(buffer));
    int bytes = read(fd, buffer, sizeof(buffer) - 1);
    if (bytes > 0) {
        printf("[User-Space] Mesaj primit de la Driver: %s\n", buffer);
    } else {
        printf("[User-Space] Nu s-au putut citi date.\n");
    }
    
    close(fd);
    return 0;
}