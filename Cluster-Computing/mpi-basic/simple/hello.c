#include <stdio.h>
#include <unistd.h>
#include <mpi.h>

void main(int argc, char *argv[]){
        int rank, size, name_len;
        char processor_name[MPI_MAX_PROCESSOR_NAME];

        MPI_Init(&argc, &argv);
        MPI_Comm_size(MPI_COMM_WORLD, &size);
        MPI_Comm_rank(MPI_COMM_WORLD, &rank);
        MPI_Get_processor_name(processor_name, &name_len);

        sleep(rank);
        printf("Hello from processor %s, rank %d out of %d processors\n", processor_name, rank, size);

        MPI_Finalize();
}
