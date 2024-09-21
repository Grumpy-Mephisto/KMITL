# PBS directives
#PBS -N MPI_With_PBS
#PBS -l nodes=2:ppn=2 # adjustable nodes
#PBS -q test
#PBS -j oe # combine stout and stderr

# Shell script
NCPU=$(wc -l <$PBS_NODEFILE)
echo "------------------------------------------"
echo "This job is allocated on '${NCPU}' cpu(s)"
echo "Job is running on node(s): "
cat $PBS_NODEFILE
echo "------------------------------------------"
echo "PBS: qsub is running on $PBS_O_HOST"

MPIEXE="/share/apps/mpich/3.2.1-gcc8.1.0/bin"
WORKDIR="$HOME/Developments/basic-mpi/simple-mpi"
SOURCEFILE="$WORKDIR/simple-mpi.c"
EXECUTABLE="$WORKDIR/simple-mpi.out"

# Compile MPI
echo "Compiling the source file..."
COMPILE="$MPIEXE/mpicc"
$COMPILE $SOURCEFILE -o $EXECUTABLE
if [ $? -ne 0 ]; then
  echo "Compilation failed!"
  exit 1
fi

# Run Program
echo "Compilation succeeded, running the MPI program..."
LAUNCH="$MPIEXE/mpirun -np $NCPU -machinefile $PBS_NODEFILE"
time $LAUNCH $EXECUTABLE
exit
