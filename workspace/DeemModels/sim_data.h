
#include "sim_struct.h"

#define num_var 3
#define num_studi 1
#define num_casi 1
#define num_place 14
#define num_trans 7
#define num_trans_immediate 1
#define num_misure 7
#define num_misure_INST 7
#define num_misure_CUM 0
#define num_misure_AVERAGED 0
#define num_misure_IMP_INST 0
#define num_misure_IMP_CUM 0
#define num_misure_IMP_AVERAGED 0
#define num_misure_composte 0


char net_name[256]="unnamed";
char input_file[256]="TestCHESS";
char misure_temp[256]="TestCHESS-misure_temp";


char misure_output[256]="TestCHESS-misure_output.txt";


char nome_variabili[3][256]={ "Time" , "Param1" , "Param2" };
double variabili[3];
int init_marking[14];
int marking[14]={ 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 };

int st0_var_multivalore[3]={ 1 , 1 , 1 };
double st0_var_valori[]={  };

struct struct_study studi[1]={
	{ "TestCHESS" , 1 , 0 , st0_var_multivalore , st0_var_valori } };

char riepilogo_studio[1][3][1024]={
	{ "1.000000e+01" ,
	  "5.000000e-01" ,
	  "2.000000e+01"} };

double casi[1][3]={
	{ 1.000000e+01 , 5.000000e-01 , 2.000000e+01 } };

struct int2 tr0_imm_list[1]={ {0,1} };
int tr0_tmp_list[0]={  };
int tr0_rate_list[0]={  };
struct int2 tr1_imm_list[0]={  };
int tr1_tmp_list[1]={ 1 };
int tr1_rate_list[0]={  };
struct int2 tr2_imm_list[0]={  };
int tr2_tmp_list[1]={ 2 };
int tr2_rate_list[0]={  };
struct int2 tr3_imm_list[0]={  };
int tr3_tmp_list[1]={ 3 };
int tr3_rate_list[0]={  };
struct int2 tr4_imm_list[0]={  };
int tr4_tmp_list[1]={ 4 };
int tr4_rate_list[0]={  };
struct int2 tr5_imm_list[0]={  };
int tr5_tmp_list[1]={ 5 };
int tr5_rate_list[0]={  };
struct int2 tr6_imm_list[0]={  };
int tr6_tmp_list[1]={ 6 };
int tr6_rate_list[0]={  };

int immdiate_trans_ind[1];
int timed_trans_ind[6];

struct struct_trans transizioni[7]={
	{ 0 , "t_Instantaneous" ,	  tr0_imm_list , 1 , tr0_tmp_list , 0 , tr0_rate_list , 0 ,
	  tr0_mod_func , tr0_enab_func , tr0_prob_func , { -1, 1 } } ,
	{ 5 , "t_Exponential" ,	  tr1_imm_list , 0 , tr1_tmp_list , 1 , tr1_rate_list , 0 ,
	  tr1_mod_func , tr1_enab_func , tr1_rate_func , { -1, 1 } } ,
	{ 3 , "t_Deterministic" ,	  tr2_imm_list , 0 , tr2_tmp_list , 1 , tr2_rate_list , 0 ,
	  tr2_mod_func , tr2_enab_func , tr2_rate_func , { -1, 1 } } ,
	{ 11 , "t_Gaussian" ,	  tr3_imm_list , 0 , tr3_tmp_list , 1 , tr3_rate_list , 0 ,
	  tr3_mod_func , tr3_enab_func , tr3_rate_func , { -1, 1 } } ,
	{ 13 , "t_Uniform" ,	  tr4_imm_list , 0 , tr4_tmp_list , 1 , tr4_rate_list , 0 ,
	  tr4_mod_func , tr4_enab_func , tr4_rate_func , { -1, 1 } } ,
	{ 6 , "t_Gamma" ,	  tr5_imm_list , 0 , tr5_tmp_list , 1 , tr5_rate_list , 0 ,
	  tr5_mod_func , tr5_enab_func , tr5_rate_func , { -1, 1 } } ,
	{ 14 , "t_Weibull" ,	  tr6_imm_list , 0 , tr6_tmp_list , 1 , tr6_rate_list , 0 ,
	  tr6_mod_func , tr6_enab_func , tr6_rate_func , { -1, 1 } } };

int transizioni_schedulate[7]={ -1 , 0 , 0 , 0 , 0 , 0 , 0 };
int transizioni_da_testare[7]={ 0 , 0 , 0 , 0 , 0 , 0 , 0 };
int transizioni_con_rate_alterato[7]={ -1 , 0 , 0 , 0 , 0 , 0 , 0 };

struct struct_reward misure[7]={
	{ 0 , "p_Instantaneous" , m0_rew_func , 0.000000e+00 , 0.000000e+00 , 0.000000e+00 , 0.000000e+00 , 0 } ,
	{ 0 , "p_Exponential" , m1_rew_func , 0.000000e+00 , 0.000000e+00 , 0.000000e+00 , 0.000000e+00 , 0 } ,
	{ 0 , "p_Deterministic" , m2_rew_func , 0.000000e+00 , 0.000000e+00 , 0.000000e+00 , 0.000000e+00 , 0 } ,
	{ 0 , "p_Gaussian" , m3_rew_func , 0.000000e+00 , 0.000000e+00 , 0.000000e+00 , 0.000000e+00 , 0 } ,
	{ 0 , "p_Uniform" , m4_rew_func , 0.000000e+00 , 0.000000e+00 , 0.000000e+00 , 0.000000e+00 , 0 } ,
	{ 0 , "p_Gamma" , m5_rew_func , 0.000000e+00 , 0.000000e+00 , 0.000000e+00 , 0.000000e+00 , 0 } ,
	{ 0 , "p_Weibull" , m6_rew_func , 0.000000e+00 , 0.000000e+00 , 0.000000e+00 , 0.000000e+00 , 0 } };

char riepilogo_misure[7][1024]={
	{ "IF(MARK(EndInstantaneous)>0)THEN(1)ELSE(0)" } ,
	{ "IF(MARK(EndExponential)>0)THEN(1)ELSE(0)" } ,
	{ "IF(MARK(EndDeterministic)>0)THEN(1)ELSE(0)" } ,
	{ "IF(MARK(EndGaussian)>0)THEN(1)ELSE(0)" } ,
	{ "IF(MARK(EndUniform)>0)THEN(1)ELSE(0)" } ,
	{ "IF(MARK(EndGamma)>0)THEN(1)ELSE(0)" } ,
	{ "IF(MARK(EndWeibull)>0)THEN(1)ELSE(0)" } };

int misure_INST[7]={ 0 , 1 , 2 , 3 , 4 , 5 , 6 };
int misure_CUM[0]={ };
int misure_AVERAGED[0]={ };

int misure_IMP_INST[0]={ };
int misure_IMP_CUM[0]={ };
int misure_IMP_AVERAGED[0]={ };

struct struct_comp_reward misure_composte[0]={
 };

int misure_to_test[7]={ 0 , 0 , 0 , 0 , 0 , 0 , 0 };

