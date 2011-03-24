#include "RewTest01PVModel.h"

RewTest01PVModel::RewTest01PVModel(bool expandTimeArrays) {
  TheModel=new Test01SAN();
  DefineName("RewTest01PVModel");
  CreatePVList(7, expandTimeArrays);
  Initialize();
}



PerformanceVariableNode* RewTest01PVModel::createPVNode(int pvindex, int timeindex) {
  switch(pvindex) {
  case 0:
    return new RewTest01PV0(timeindex);
    break;
  case 1:
    return new RewTest01PV1(timeindex);
    break;
  case 2:
    return new RewTest01PV2(timeindex);
    break;
  case 3:
    return new RewTest01PV3(timeindex);
    break;
  case 4:
    return new RewTest01PV4(timeindex);
    break;
  case 5:
    return new RewTest01PV5(timeindex);
    break;
  case 6:
    return new RewTest01PV6(timeindex);
    break;
  }
  return NULL;
}
