OBJS=RewTest01PVNodes.o RewTest01PVModel.o 


#include common Makefile for default targets
include ../../Makefile.project
include $(MOBIUSROOT)/Cpp/BaseClasses/Makefile.common

all: normal
opt: $(ROOTDIR)/lib/$(ARCH)_lib/libRewTest01PV.a
normal debug trace: $(ROOTDIR)/lib/$(ARCH)_lib/libRewTest01PV_debug.a

$(ROOTDIR)/lib/$(ARCH)_lib/libRewTest01PV.a: FORCE
	$(MAKE) lib TARGET=libRewTest01PV.a OBJS="$(OBJS)" USERINCLUDE="$(USERINCLUDE)" TYPE="" ROOTLIBDIR="."

$(ROOTDIR)/lib/$(ARCH)_lib/libRewTest01PV_debug.a: FORCE
	$(MAKE) lib TARGET=libRewTest01PV_debug.a OBJS="$(OBJS)" USERINCLUDE="$(USERINCLUDE)" TYPE="_debug" ROOTLIBDIR="."

clean_sub_dirs:

