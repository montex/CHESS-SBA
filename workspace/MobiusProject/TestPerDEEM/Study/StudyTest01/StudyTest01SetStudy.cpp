
#include "Study/StudyTest01/StudyTest01SetStudy.h"

//******************************************************
//Global Variables
//******************************************************
double Param1;
double Param2;
double TestTime;

//********************************************************
//StudyTest01SetStudy Constructor
//********************************************************
StudyTest01SetStudy::StudyTest01SetStudy() {

  // define arrays of global variable names and types
  NumGVs = 3;
  NumExps = 1;

  GVNames = new char*[NumGVs];
  GVTypes = new char*[NumGVs];
  GVNames[0]=strdup("Param1");
  GVTypes[0]=strdup("double");
  GVNames[1]=strdup("Param2");
  GVTypes[1]=strdup("double");
  GVNames[2]=strdup("TestTime");
  GVTypes[2]=strdup("double");

  // create the arrays to store the values of each gv
  Param1Values = new double[NumExps];
  Param2Values = new double[NumExps];
  TestTimeValues = new double[NumExps];

  // call methods to assign values to each gv
  SetValues_Param1();
  SetValues_Param2();
  SetValues_TestTime();
  SetDefaultMobiusRoot(MOBIUSROOT);
}


//******************************************************
//StudyTest01SetStudy Destructor
//******************************************************
StudyTest01SetStudy::~StudyTest01SetStudy() {
  delete [] Param1Values;
  delete [] Param2Values;
  delete [] TestTimeValues;
  delete ThePVModel;
}


//******************************************************
// set values for Param1
//******************************************************
void StudyTest01SetStudy::SetValues_Param1() {
  Param1Values[0] = 0.5;
}


//******************************************************
// set values for Param2
//******************************************************
void StudyTest01SetStudy::SetValues_Param2() {
  Param2Values[0] = 20.0;
}


//******************************************************
// set values for TestTime
//******************************************************
void StudyTest01SetStudy::SetValues_TestTime() {
  TestTimeValues[0] = 10.0;
}



//******************************************************
//print values of gv (for debugging)
//******************************************************
void StudyTest01SetStudy::PrintGlobalValues(int expNum) {
  if (NumGVs == 0) {
    cout<<"There are no global variables."<<endl;
    return;
  }

  SetGVs(expNum);

  cout<<"The Global Variable values for experiment "<<
    GetExpName(expNum)<<" are:"<<endl;
  cout << "Param1\tdouble\t" << Param1 << endl;
  cout << "Param2\tdouble\t" << Param2 << endl;
  cout << "TestTime\tdouble\t" << TestTime << endl;
}


//******************************************************
//retrieve the value of a global variable
//******************************************************
void *StudyTest01SetStudy::GetGVValue(char *TheGVName) {
  if (strcmp("Param1", TheGVName) == 0)
    return &Param1;
  else if (strcmp("Param2", TheGVName) == 0)
    return &Param2;
  else if (strcmp("TestTime", TheGVName) == 0)
    return &TestTime;
  else 
    cerr<<"!! StudyTest01SetStudy::GetGVValue: Global Variable "<<TheGVName<<" does not exist."<<endl;
  return NULL;
}


//******************************************************
//override the value of a global variable
//******************************************************
void StudyTest01SetStudy::OverrideGVValue(char *TheGVName,void *TheGVValue) {
  if (strcmp("Param1", TheGVName) == 0)
    Param1 = *(double *)TheGVValue;
  else if (strcmp("Param2", TheGVName) == 0)
    Param2 = *(double *)TheGVValue;
  else if (strcmp("TestTime", TheGVName) == 0)
    TestTime = *(double *)TheGVValue;
  else 
    cerr<<"!! StudyTest01SetStudy::OverrideGVValue: Global Variable "<<TheGVName<<" does not exist."<<endl;
}


//******************************************************
//set the value of all global variables to the given exp
//******************************************************
void StudyTest01SetStudy::SetGVs(int expNum) {
  Param1 = Param1Values[expNum];
  Param2 = Param2Values[expNum];
  TestTime = TestTimeValues[expNum];
}


//******************************************************
//static class method called by solvers to create study 
//(and thus create all of the model)
//******************************************************
BaseStudyClass* GlobalStudyPtr = NULL;
BaseStudyClass * GenerateStudy() {
  if (GlobalStudyPtr == NULL)
    GlobalStudyPtr = new StudyTest01SetStudy();
  return GlobalStudyPtr;
}

void DestructStudy() {
  delete GlobalStudyPtr;
  GlobalStudyPtr = NULL;
}
//******************************************************
//get and create the PVModel
//******************************************************
PVModel* StudyTest01SetStudy::GetPVModel(bool expandTimeArrays) {
  if (ThePVModel!=NULL)
    delete ThePVModel;
  // create the PV model
  ThePVModel=new RewTest01PVModel(expandTimeArrays);
  return ThePVModel;
}


