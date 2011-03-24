OBJS=


#include common Makefile for default targets
include ../../Makefile.project
include $(MOBIUSROOT)/Cpp/BaseClasses/Makefile.common

BINDIR=
MAINLIB=-lsimMain
MAINLIB_debug=-lsimMain_debug
SIMLIB=sim
SIMLIB_debug=sim_debug
SIMLIB_trace=sim_trace
PROJECTLIBS=-lStudyTest01SetStudy -lRewTest01PV -lTest01SAN 
PROJECTLIBS_debug=-lStudyTest01SetStudy_debug -lRewTest01PV_debug -lTest01SAN_debug 
MOBIUSLIBS=-lTRex -lStudy -lPV -lSAN -lbase -lstate -lmobutil -ldist 
MOBIUSLIBS_debug=-lTRex_debug -lStudy_debug -lPV_debug -lSAN_debug -lbase_debug -lstate_debug -lmobutil_debug -ldist_debug 
USERDEFLIBNAME=
USERDEFLIBDIR=

all: normal

opt \
SimTest01Sim_$(ARCH): SUBMODELS/opt
	$(MAKE) exec3 "TARGET=SimTest01Sim_$(ARCH)" "USERLIBDIR=-L$(MOBIUSROOT)/Cpp/lib/$(ARCH)_lib $(USERDEFLIBDIR)" "USERLIB=$(MAINLIB) -l$(SIMLIB) $(USERDEFLIBNAME) $(PROJECTLIBS) $(USERDEFLIBNAME) $(MOBIUSLIBS)" 

normal debug \
SimTest01Sim_$(ARCH)_debug: SUBMODELS/debug
	$(MAKE) exec3 "TARGET=SimTest01Sim_$(ARCH)_debug" "USERLIBDIR=-L$(MOBIUSROOT)/Cpp/lib/$(ARCH)_lib $(USERDEFLIBDIR)" "USERLIB=$(MAINLIB_debug) -l$(SIMLIB_debug) $(USERDEFLIBNAME) $(PROJECTLIBS_debug) $(USERDEFLIBNAME) $(MOBIUSLIBS_debug) " "BUILDTARGET=_debug"

trace \
SimTest01Sim_$(ARCH)_trace:
	$(MAKE) exec3 "TARGET=SimTest01Sim_$(ARCH)_trace" "USERLIBDIR=-L$(MOBIUSROOT)/Cpp/lib/$(ARCH)_lib $(USERDEFLIBDIR)" "USERLIB=$(MAINLIB_debug) -l$(SIMLIB_trace) $(USERDEFLIBNAME) $(PROJECTLIBS_debug) $(USERDEFLIBNAME) $(MOBIUSLIBS_debug) " "BUILDTARGET=_debug"

clean_sub_dirs:
	cd ../../Atomic/Test01/ && $(MAKE) clean
	cd ../../Reward/RewTest01/ && $(MAKE) clean
	cd ../../Study/StudyTest01/ && $(MAKE) clean

SUBMODELS/opt SUBMODELS/debug:
	@echo "NEW_SUBMODEL_LIB:[Test01]"
	cd ../../Atomic/Test01/ && $(MAKE) $(@F)
	@echo "NEW_SUBMODEL_LIB:[RewTest01]"
	cd ../../Reward/RewTest01/ && $(MAKE) $(@F)
	@echo "NEW_SUBMODEL_LIB:[StudyTest01]"
	cd ../../Study/StudyTest01/ && $(MAKE) $(@F)


