#!/bin/sh 
#*********************************
#  Deem Simulator: launch script *
#*********************************

# "DEEM_SIM_HOME" is the path name of the directory where
# deem simulator has been installed.
#
#if [ ! $DEEM_SIM_HOME ];
#then
	#DEEM_SIM_HOME="$HOME/deem_project/devel-deem/deem-simulator.src/deem-simulator-current.src"
        DEEM_SIM_HOME="/usr/local/sim/deem-simulator-1.2"
#fi

# "DEEM_SIM_MODELS=" is the path name of the directory where
# is the model to simulate.
# It must be the current directory.
#
DEEM_SIM_MODELS="$PWD"

# the generator of the deem smulator
DEEMSIMGEN=deemSimGenerator

SIM_MODEL_FILES="$1-s.sim sim_func.o sim_main.o sim_data.h sim_func.c sim_func.h mrand.o sim_distr.o"

if [ "$#" -lt 1 ]; then
       echo "Usage: $0 <netfilename> [-r [savefilename]]" 1>&2
       echo ""
       exit 1
fi

if [ ! -x "$DEEM_SIM_HOME/bin/${DEEMSIMGEN}" ]
then
        echo ""
        echo " ---- Deem simulator is unavailable for this system ---"
	echo ""
        exit
fi

# Environment variables of Deem simulator
#---------------------------------------

export DEEM_SIM_MODELS DEEM_SIM_HOME 
#---------------------------------------

echo ""
echo " Starting Deem simulator ... "
echo ""
 
echo "cd ${DEEM_SIM_MODELS}"; cd ${DEEM_SIM_MODELS}
echo "rm -f $SIM_MODEL_FILES"; rm -f $SIM_MODEL_FILES
echo "Compiling..."; ${DEEM_SIM_HOME}/bin/${DEEMSIMGEN} -i $1
echo "Running..."; time ${DEEM_SIM_MODELS}/${1}-s.sim $2
 
