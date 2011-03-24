
#ifndef StudyTest01SetSTUDY_H_
#define StudyTest01SetSTUDY_H_

#include "Reward/RewTest01/RewTest01PVNodes.h"
#include "Reward/RewTest01/RewTest01PVModel.h"
#include "Cpp/Study/BaseStudyClass.hpp"

extern double Param1;
extern double Param2;
extern double TestTime;

class StudyTest01SetStudy : public BaseStudyClass {
public:

StudyTest01SetStudy();
~StudyTest01SetStudy();

private:

double *Param1Values;
double *Param2Values;
double *TestTimeValues;

void SetValues_Param1();
void SetValues_Param2();
void SetValues_TestTime();

void PrintGlobalValues(int);
void *GetGVValue(char *TheGVName);
void OverrideGVValue(char *TheGVName, void *TheGVValue);
void SetGVs(int expnum);
PVModel *GetPVModel(bool expandTimeArrays);
};

#endif

