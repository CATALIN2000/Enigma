Nume: Oprica
Prenume: Adrian-Catalin
Grupa: 331CA

Ierarhia fisierelor:
FileParser - folosit pentru prelucrarea inputului
Main -  unde se face prelucrarea efectiva a inputului
Pair - clasa ajutatoare pentru mentinerea charuruilor din reflector
Componentele masinii:
-Plugboard
-Rotor
-Inel
-Reflector
-Enigma - unde se fac toate operatiile de criptare

Am ales aceasta ierarhie de fisiere pentru ca imi este mai usor sa identific
un obiect daca are fiecare fisier propriu. Am structurat acest proiect
astfel incat sa am fiecare componenta fizica a masinii separat si apoi
sa le unesc pe toate intr-o componenta mai mare numita Enigma.

Rotor - aceasta clasa permite crearea unui anumit rotor prin
parametrul constructorului => putem avea oricate rotoare el il 
va construi pe cel specific si care ne trebuie. Prin crearea 
in acest mod a clasei ea poate fi usor extina la mai multe rotoare.

Inel -  aceasta clasa este exact acelasi lucru cu Rotor , singura 
diferenta fata de rotor este ca are o variabila notch in plus
care ne ajuta sa identificam cand trebuie sa miscam rotoarele
in masina. Am ales sa implementez aceasta ca si clasa separata
deoarece imi este mai usor in identificarea lor si a functionalitaii.

Reflector - aceasta clasa permite crearea reflectorului de care avem
nevoie. Poate fi usor extinsa prin adaugarea unui nou reflector.
Selectarea reflectorului se va face prin constructor, se cere 
prin parametru reflectorul de care avem nevoie.

Plugboard - in plugboard se construieste translatiile de litere
cum doreste utilizatorul

Enigma - Enigma se foloseste de celelalte componente pentru criptarea
unui caracter primit. In implementarea acestei clase am ales sa fac 
urmatoarele lucruri:
	- am folosit acelasi cod si pentru criptare si pentru decriptare,
	chiar daca am cod duplicat imi este mai usor sa imi dau seama
	unde se face criptarea si unde se face decriptarea
	
Prezentarea criptarii:
A:pentru criptarea datelor se folosesc urmatorii pasi:
	1.se calculeaza litera care trebuie bagata in rotor dupa urmatoarea
	formula literaout = literain + offsetrotor - offsetinel + rotatie rotor
	2.se trece litera rezultata prin rotor
	3.litera finala la iesirea din rotor se calculeaza dupa urmatoarea
	formula literaout = literain - offsetrotor + offsetinel - rotatie inel
	
	Din cauza ca se poate iesi din indexul rotorului am adunat un overflow 
	la fiecare formula si am facut modulo 26 pentru a ma asigura ca nu
	depaseste spatiul de litere care il am
B:se face ce am specificat mai sus pentru fiecare rotor in parte
C:se trece litera prin reflector
D:la intoarecere se trece prin toate rotoarele pana ajunge la plugboard

Traseul literei prin masina se face in felul urmator:
Se porneste litera de input care trece pentru prima oara prin plugboard.
Iesirea plugboardului e adaugata ca intrare pentru primul rotor.
Iesirea primului rotor e intrarea celui de al 2 lea.
----------------------------------------------------
Iesirea celui de al n-1 rotor este intrarea celui de al n lea rotor.
Se trece outputul celui de al n lea rotor prin reflector.
Iesirea reflectorului este intrare pentru cel de al n lea rotor.
----------------------------------------------------
Iesirea celui de al 3 lea rotor este intrare pentru al 2 lea.
Iesirea celui de al 2 lea rotor este intrare pentru primul rotor.
Iesirea primului rotor este intrare pentru plugboard.
Plugboardul returneaza litera finala.

Prin implementarea care am specificat-o mai sus nu conteaza 
numarul de rotare care il avem, putem avea oricate =>
putem avea o extindere usoara a modelului.

Intrebare: De ce primim la input tipul operatiei specifice?
Daca se face exact acelasi lucru si pentru criptare si pentru
decriptare.

Impedimente in rezolvarea temei au fost urmarirea literei prin
traseul parcurs prin masina, pentru solutionarea lor mai multe
detalii in cod la sectiunile //debug code