#PBS -N parallel
#PBS -l nodes=1:ppn=4
#PBS -q test

# Find file
export OMP_NUM_THREADS=4
WORKDIR="/home/kmitl0437/Developments/basic-pbs"
cd $WORKDIR
echo -e "$(date)"
echo -e "$(hostname)"
echo -e "Job name ${PBS_JOBNAME}"

# Run file
time ./parallel.out
