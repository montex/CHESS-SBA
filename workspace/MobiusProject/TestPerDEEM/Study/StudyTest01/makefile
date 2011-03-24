OBJS=StudyTest01SetStudy.o 


#include common Makefile for default targets
include ../../Makefile.project
include $(MOBIUSROOT)/Cpp/BaseClasses/Makefile.common

all: normal
opt: $(ROOTDIR)/lib/$(ARCH)_lib/libStudyTest01SetStudy.a
normal debug trace: $(ROOTDIR)/lib/$(ARCH)_lib/libStudyTest01SetStudy_debug.a

$(ROOTDIR)/lib/$(ARCH)_lib/libStudyTest01SetStudy.a: FORCE
	$(MAKE) lib TARGET=libStudyTest01SetStudy.a OBJS="$(OBJS)" USERINCLUDE="$(USERINCLUDE)" TYPE="" ROOTLIBDIR="."

$(ROOTDIR)/lib/$(ARCH)_lib/libStudyTest01SetStudy_debug.a: FORCE
	$(MAKE) lib TARGET=libStudyTest01SetStudy_debug.a OBJS="$(OBJS)" USERINCLUDE="$(USERINCLUDE)" TYPE="_debug" ROOTLIBDIR="."

clean_sub_dirs:

