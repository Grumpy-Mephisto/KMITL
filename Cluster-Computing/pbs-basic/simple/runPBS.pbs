#PBS -N hello
#PBS -l nodes=1:ppn=4
#PBS -q test # don't forget to change the queue

# Find file
WORKDIR="/home/kmitl0437/Developments/hello"
cd $WORKDIR
echo -e "$(date)"
echo -e "$(hostname)"
echo -e "Job name ${PBS_JOBNAME}"

# Run file
./hello.out
