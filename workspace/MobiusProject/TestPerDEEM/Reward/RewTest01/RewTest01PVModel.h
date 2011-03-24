#ifndef _REWTEST01_PVMODEL_
#define _REWTEST01_PVMODEL_
#include "RewTest01PVNodes.h"
#include "Cpp/Performance_Variables/PVModel.hpp"
#include "Atomic/Test01/Test01SAN.h"
class RewTest01PVModel:public PVModel {
 protected:
  PerformanceVariableNode *createPVNode(int pvindex, int timeindex);
 public:
  RewTest01PVModel(bool expandtimepoints);
};

#endif
