set terminal svg enhanced

set xlabel 'Time t (hours)' 
set ylabel 'R(t)' 

set xtics format "%.0e"

set title "Reliability of component \"Receiver\\_impl\\_inst\"\r\n\r\nfo: Fault occurrence rate of the Analyzer component"

set output "model4review-faultocc.svg"
plot './results-model4review.txt' u 1:4 ev :::0::0 t "fo = 1.0E-05 hours^{-1}" w lp,\
	 './results-model4review.txt' u 1:4 ev :::1::1 t "fo = 5.0E-05 hours^{-1}" w lp

set title "Reliability of component \"Receiver\\_impl\\_inst\"\r\n\r\np: Probability of propagation from SerialCable to BoardSystem"

set yrange [0:1.1]
set key bottom left
set output "model4review-propprob.svg"
plot './results-model4review.txt' u 1:4 ev :::0::0 t 'p=1.0' w lp,\
	 './results-model4review.txt' u 1:4 ev :::2::2 t 'p=0.1' w lp

