OBJS=Test01SAN.o 


#include common Makefile for default targets
include ../../Makefile.project
include $(MOBIUSROOT)/Cpp/BaseClasses/Makefile.common

all: normal
opt: $(ROOTDIR)/lib/$(ARCH)_lib/libTest01SAN.a
normal debug trace: $(ROOTDIR)/lib/$(ARCH)_lib/libTest01SAN_debug.a

$(ROOTDIR)/lib/$(ARCH)_lib/libTest01SAN.a: FORCE
	$(MAKE) lib TARGET=libTest01SAN.a OBJS="$(OBJS)" USERINCLUDE="$(USERINCLUDE)" TYPE="" ROOTLIBDIR="."

$(ROOTDIR)/lib/$(ARCH)_lib/libTest01SAN_debug.a: FORCE
	$(MAKE) lib TARGET=libTest01SAN_debug.a OBJS="$(OBJS)" USERINCLUDE="$(USERINCLUDE)" TYPE="_debug" ROOTLIBDIR="."

clean_sub_dirs:

