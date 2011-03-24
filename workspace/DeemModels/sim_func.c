
#include <math.h>
#include "sim_struct.h"
#include "sim_distr.h"


#define max(A,B) ((A)>(B)?(A):(B))

#define min(A,B) ((A)<(B)?(A):(B))

extern struct int2 tr0_imm_list[1];
extern int tr0_tmp_list[0];
extern int tr0_rate_list[0];

extern struct int2 tr1_imm_list[0];
extern int tr1_tmp_list[1];
extern int tr1_rate_list[0];

extern struct int2 tr2_imm_list[0];
extern int tr2_tmp_list[1];
extern int tr2_rate_list[0];

extern struct int2 tr3_imm_list[0];
extern int tr3_tmp_list[1];
extern int tr3_rate_list[0];

extern struct int2 tr4_imm_list[0];
extern int tr4_tmp_list[1];
extern int tr4_rate_list[0];

extern struct int2 tr5_imm_list[0];
extern int tr5_tmp_list[1];
extern int tr5_rate_list[0];

extern struct int2 tr6_imm_list[0];
extern int tr6_tmp_list[1];
extern int tr6_rate_list[0];

extern double variabili[3];
extern int init_marking[14];
extern int marking[14];
extern struct struct_trans transizioni[7];
extern struct struct_reward misure[7];
extern double casi[1][3];

extern int seed;


/*** SET_VARIABILI ***/

void set_variabili(int caso)
{
	int i;
	for(i=0; i<3; i++) variabili[i] = casi[caso][i];
}


/*** SET_INIT_MARKING ***/

void set_init_marking()
{
	init_marking[0] = 1;
	init_marking[1] = 1;
	init_marking[2] = 1;
	init_marking[3] = 1;
	init_marking[4] = 1;
	init_marking[5] = 1;
	init_marking[6] = 1;
	init_marking[7] = 0;
	init_marking[8] = 0;
	init_marking[9] = 0;
	init_marking[10] = 0;
	init_marking[11] = 0;
	init_marking[12] = 0;
	init_marking[13] = 0;
}


/*** RESET_MARKING ***/

void reset_marking()
{
	int i;
	for(i=0; i<14; i++) marking[i] = init_marking[i];
}


/*** PRIO_VAR_FUNC ***/

void prio_var_func(int caso)
{
}



/*** LOOP_IMMEDIATE ***/

int loop_immediate(int trans)
{
	switch(trans)
	{
		default:
			return 0;
	}
}



/*** TRANSIZIONE #0 't_Instantaneous' ***/

int tr0_enab_func()
{
	if(!(marking[0] >= 1)) return 0;
	return 1;
}

void tr0_mod_func()
{
	marking[0] -= 1 ;
	marking[7] += 1 ;
}

double tr0_prob_func()
{
	return 1.000000e+00;
}


/*** TRANSIZIONE #1 't_Exponential' ***/

int tr1_enab_func()
{
	if(!(marking[1] >= 1)) return 0;
	return 1;
}

void tr1_mod_func()
{
	marking[1] -= 1 ;
	marking[8] += 1 ;
}

double tr1_rate_func()
{
	double par1 = variabili[1] ;
	int stream = seed;
	//Distribuzione Exponential
	// par1 <-> rate
	return distr_exponential(par1,stream);
}


/*** TRANSIZIONE #2 't_Deterministic' ***/

int tr2_enab_func()
{
	if(!(marking[2] >= 1)) return 0;
	return 1;
}

void tr2_mod_func()
{
	marking[2] -= 1 ;
	marking[9] += 1 ;
}

double tr2_rate_func()
{
	double par1 = variabili[1] ;
	int stream = seed;
	//Distribuzione Deterministic
	// par1 <-> value
	return par1;
}


/*** TRANSIZIONE #3 't_Gaussian' ***/

int tr3_enab_func()
{
	if(!(marking[3] >= 1)) return 0;
	return 1;
}

void tr3_mod_func()
{
	marking[3] -= 1 ;
	marking[10] += 1 ;
}

double tr3_rate_func()
{
	double par1 = variabili[1] ;
	double par2 = 20 ;
	int stream = seed;
	//Distribuzione Normal
	// par1 <-> mean
	// par2 <-> variance
	return distr_normal(par1,par2,stream);
}


/*** TRANSIZIONE #4 't_Uniform' ***/

int tr4_enab_func()
{
	if(!(marking[4] >= 1)) return 0;
	return 1;
}

void tr4_mod_func()
{
	marking[4] -= 1 ;
	marking[11] += 1 ;
}

double tr4_rate_func()
{
	double par1 = variabili[1] ;
	double par2 = 20 ;
	int stream = seed;
	//Distribuzione Uniform
	// par1 <-> lowerbound
	// par2 <-> upperbound
	return distr_uniform(par1,par2,stream);
}


/*** TRANSIZIONE #5 't_Gamma' ***/

int tr5_enab_func()
{
	if(!(marking[5] >= 1)) return 0;
	return 1;
}

void tr5_mod_func()
{
	marking[5] -= 1 ;
	marking[12] += 1 ;
}

double tr5_rate_func()
{
	double par1 = variabili[1] ;
	double par2 = 20 ;
	int stream = seed;
	//Distribuzione Gamma
	// par1 <-> alfa
	// par2 <-> beta
	return distr_gamma(par1,par2,stream);
}


/*** TRANSIZIONE #6 't_Weibull' ***/

int tr6_enab_func()
{
	if(!(marking[6] >= 1)) return 0;
	return 1;
}

void tr6_mod_func()
{
	marking[6] -= 1 ;
	marking[13] += 1 ;
}

double tr6_rate_func()
{
	double par1 = variabili[1] ;
	double par2 = 20 ;
	int stream = seed;
	//Distribuzione Weibull
	// par1 <-> alfa
	// par2 <-> beta
	return distr_weibull(par1,par2,stream);
}



/*** REW #0 'p_Instantaneous' ***/

double m0_rew_func()
{
	 return ((((marking[7] > 0)?(1):(0)))) ;
}


/*** REW #1 'p_Exponential' ***/

double m1_rew_func()
{
	 return ((((marking[8] > 0)?(1):(0)))) ;
}


/*** REW #2 'p_Deterministic' ***/

double m2_rew_func()
{
	 return ((((marking[9] > 0)?(1):(0)))) ;
}


/*** REW #3 'p_Gaussian' ***/

double m3_rew_func()
{
	 return ((((marking[10] > 0)?(1):(0)))) ;
}


/*** REW #4 'p_Uniform' ***/

double m4_rew_func()
{
	 return ((((marking[11] > 0)?(1):(0)))) ;
}


/*** REW #5 'p_Gamma' ***/

double m5_rew_func()
{
	 return ((((marking[12] > 0)?(1):(0)))) ;
}


/*** REW #6 'p_Weibull' ***/

double m6_rew_func()
{
	 return ((((marking[13] > 0)?(1):(0)))) ;
}


/*** VALUTA_MISURE_IMP_INST ***/

void valuta_misure_IMP_INST(int evento)
{
}

