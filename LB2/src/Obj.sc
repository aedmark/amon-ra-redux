;;; Sierra Script 1.0 - (do not remove this comment)
(script# 999)
(include sci.sh)
(use Main)
(use Print)

(public
	proc999_0 0
	proc999_1 1
	proc999_2 2
	proc999_3 3
	proc999_4 4
	proc999_5 5
	proc999_6 6
	proc999_7 7
)

(procedure (proc999_0 param1)
	(return (if (< param1 0) -1 else (> param1 0)))
)

(procedure (proc999_1 param1 param2)
	(if
		(<
			(= param1 (- param1 (* param2 (/ param1 param2))))
			0
		)
		(= param1 (+ param1 param2))
	)
	(return param1)
)

(procedure (proc999_2 param1 &tmp temp0)
	(return
		(if
			(or
				(== argc 1)
				(< param1 (= temp0 (proc999_2 &rest)))
			)
			param1
		else
			temp0
		)
	)
)

(procedure (proc999_3 param1 &tmp temp0)
	(return
		(if
			(or
				(== argc 1)
				(> param1 (= temp0 (proc999_3 &rest)))
			)
			param1
		else
			temp0
		)
	)
)

(procedure (proc999_4 param1 param2 param3 param4 param5 param6)
	(return
		(if
			(and
				(<= param1 (if (< argc 6) (param5 sel_1?) else param5))
				(<= (if (< argc 6) (param5 sel_1?) else param5) param3)
			)
			(if
			(<= param2 (if (< argc 6) (param5 sel_0?) else param6))
				(<= (if (< argc 6) (param5 sel_0?) else param6) param4)
			)
		else
			0
		)
	)
)

(procedure (proc999_5 param1 param2 &tmp temp0)
	(= temp0 0)
	(while (< temp0 (- argc 1))
		(if (== param1 [param2 temp0])
			(return (if param1 else 1))
		)
		(++ temp0)
	)
	(return 0)
)

(procedure (proc999_6 param1 param2)
	(Memory memPEEK (+ param1 (* 2 param2)))
)

(procedure (proc999_7 param1 param2)
	(param1 param2: &rest)
)

(class Obj
	(properties
		sel_20 {Obj}
	)
	
	(method (sel_109)
		(Clone self)
	)
	
	(method (sel_110)
	)
	
	(method (sel_57)
		(return self)
	)
	
	(method (sel_111)
		(DisposeClone self)
	)
	
	(method (sel_112 param1)
		(StrCpy param1 sel_20)
	)
	
	(method (sel_113 &tmp [temp0 200])
		(proc921_0 (self sel_112: @temp0))
	)
	
	(method (sel_96 param1)
		(param1 sel_57: self &rest)
	)
	
	(method (sel_114 param1 &tmp objSel_4102)
		(cond 
			(
				(and
					(== sel_4098 (param1 sel_4098?))
					(== sel_4100 (param1 sel_4100?))
				)
			)
			((= objSel_4102 (self sel_4102?))
				(if (IsObject objSel_4102)
					(objSel_4102 sel_114: param1)
				)
			)
		)
	)
	
	(method (sel_115 param1)
		(return
			(cond 
				((== param1 self))
				((& (param1 sel_4103?) $8000)
					(if (not (& sel_4103 $8000))
						(== sel_4098 (param1 sel_4098?))
					)
				)
			)
		)
	)
	
	(method (sel_116 param1)
		(RespondsTo self param1)
	)
	
	(method (sel_117)
		(return self)
	)
)

(class Code of Obj
	(properties
		sel_20 {Code}
	)
	
	(method (sel_57)
	)
)

(class Collect of Obj
	(properties
		sel_20 {Collect}
		sel_24 0
		sel_86 0
	)
	
	(method (sel_57)
		(self sel_119: 57 &rest)
	)
	
	(method (sel_111)
		(if sel_24 (self sel_119: 111) (DisposeList sel_24))
		(= sel_86 (= sel_24 0))
		(super sel_111:)
	)
	
	(method (sel_112 param1)
		(Format param1 999 0 sel_20 sel_86)
	)
	
	(method (sel_113 &tmp [temp0 40])
		(proc921_0 (self sel_112: @temp0))
		(self sel_119: 113)
	)
	
	(method (sel_118 param1 &tmp temp0 temp1 temp2)
		(if (not sel_24) (= sel_24 (NewList)))
		(= temp1 0)
		(while (< temp1 argc)
			(if (not (self sel_126: [param1 temp1]))
				(AddToEnd sel_24 (NewNode [param1 temp1] [param1 temp1]))
				(++ sel_86)
			)
			(++ temp1)
		)
		(return self)
	)
	
	(method (sel_81 param1 &tmp temp0)
		(= temp0 0)
		(while (< temp0 argc)
			(if (DeleteKey sel_24 [param1 temp0]) (-- sel_86))
			(++ temp0)
		)
		(return self)
	)
	
	(method (sel_119 param1 &tmp temp0 temp1 temp2)
		(= temp0 (FirstNode sel_24))
		(while temp0
			(= temp1 (NextNode temp0))
			(if (not (IsObject (= temp2 (NodeValue temp0))))
				(return)
			)
			(temp2 param1: &rest)
			(= temp0 temp1)
		)
	)
	
	(method (sel_120 param1 &tmp temp0 temp1 temp2)
		(= temp0 (FirstNode sel_24))
		(while temp0
			(= temp1 (NextNode temp0))
			(= temp2 (NodeValue temp0))
			(if (temp2 param1: &rest) (return temp2))
			(= temp0 temp1)
		)
		(return 0)
	)
	
	(method (sel_121 param1 &tmp temp0 temp1 temp2)
		(= temp0 (FirstNode sel_24))
		(while temp0
			(= temp1 (NextNode temp0))
			(= temp2 (NodeValue temp0))
			(if (not (temp2 param1: &rest)) (return 0))
			(= temp0 temp1)
		)
		(return 1)
	)
	
	(method (sel_122 param1)
		(FindKey sel_24 param1)
	)
	
	(method (sel_123)
		(if (== sel_24 0) else (EmptyList sel_24))
	)
	
	(method (sel_124)
		(FirstNode sel_24)
	)
	
	(method (sel_65 param1)
		(NextNode param1)
	)
	
	(method (sel_125 &tmp temp0 temp1)
		(= temp0 (FirstNode sel_24))
		(while temp0
			(= temp1 (NextNode temp0))
			(self sel_81: (NodeValue temp0))
			(= temp0 temp1)
		)
	)
	
	(method (sel_126)
		(return 0)
	)
)

(class List of Collect
	(properties
		sel_20 {List}
		sel_24 0
		sel_86 0
	)
	
	(method (sel_112 param1)
		(Format param1 999 1 sel_20 sel_86)
	)
	
	(method (sel_64 param1 &tmp temp0)
		(= temp0 (FirstNode sel_24))
		(while (and param1 temp0)
			(-- param1)
			(= temp0 (NextNode temp0))
		)
		(return (if temp0 (NodeValue temp0) else 0))
	)
	
	(method (sel_127)
		(LastNode sel_24)
	)
	
	(method (sel_128 param1)
		(PrevNode param1)
	)
	
	(method (sel_129 param1 &tmp temp0)
		(if (not sel_24) (= sel_24 (NewList)))
		(= temp0 (- argc 1))
		(while (<= 0 temp0)
			(if (not (self sel_126: [param1 temp0]))
				(AddToFront
					sel_24
					(NewNode [param1 temp0] [param1 temp0])
				)
				(++ sel_86)
			)
			(-- temp0)
		)
		(return self)
	)
	
	(method (sel_130 param1 &tmp temp0)
		(if (not sel_24) (= sel_24 (NewList)))
		(= temp0 0)
		(while (< temp0 argc)
			(if (not (self sel_126: [param1 temp0]))
				(AddToEnd sel_24 (NewNode [param1 temp0] [param1 temp0]))
				(++ sel_86)
			)
			(++ temp0)
		)
		(return self)
	)
	
	(method (sel_131 param1 param2 &tmp temp0 temp1 temp2)
		(if (= temp2 (FindKey sel_24 param1))
			(-- argc)
			(= temp0 0)
			(while (< temp0 argc)
				(if (not (self sel_126: [param2 temp0]))
					(= temp2
						(AddAfter
							sel_24
							temp2
							(NewNode [param2 temp0] [param2 temp0])
						)
					)
					(++ sel_86)
				)
				(++ temp0)
			)
		)
		(return self)
	)
	
	(method (sel_132 param1 &tmp temp0 temp1)
		(= temp0 0)
		(= temp1 (FirstNode sel_24))
		(while temp1
			(if (== param1 (NodeValue temp1)) (return temp0))
			(++ temp0)
			(= temp1 (NextNode temp1))
		)
		(return -1)
	)
)

(class Set of List
	(properties
		sel_20 {Set}
		sel_24 0
		sel_86 0
	)
	
	(method (sel_112 param1)
		(Format param1 999 2 sel_20 sel_86)
	)
	
	(method (sel_126 param1)
		(self sel_122: param1)
	)
)

(class EventHandler of Set
	(properties
		sel_20 {EventHandler}
		sel_24 0
		sel_86 0
	)
	
	(method (sel_133 param1 &tmp temp0 temp1 temp2)
		(= temp0 (FirstNode sel_24))
		(while (and temp0 (not (param1 sel_73?)))
			(= temp1 (NextNode temp0))
			(breakif (not (IsObject (= temp2 (NodeValue temp0)))))
			(temp2 sel_133: param1)
			(= temp0 temp1)
		)
		(param1 sel_73?)
	)
)

(class Script of Obj
	(properties
		sel_20 {Script}
		sel_42 0
		sel_29 -1
		sel_134 0
		sel_135 0
		sel_136 0
		sel_137 0
		sel_138 0
		sel_139 0
		sel_140 0
		sel_141 0
		sel_142 0
		sel_143 0
		sel_65 0
	)
	
	(method (sel_110 theSel_42 theSel_143 theSel_141)
		(= sel_140 gSel_45)
		(if (>= argc 1)
			((= sel_42 theSel_42) sel_142: self)
			(if (>= argc 2)
				(= sel_143 theSel_143)
				(if (>= argc 3) (= sel_141 theSel_141))
			)
		)
		(= sel_29 (- sel_134 1))
		(self sel_145:)
	)
	
	(method (sel_57 &tmp theSel_138)
		(if sel_142 (sel_142 sel_57:))
		(cond 
			(sel_136 (if (not (-- sel_136)) (self sel_145:)))
			(sel_137
				(if (!= sel_138 (= theSel_138 (GetTime 1)))
					(= sel_138 theSel_138)
					(if (not (-- sel_137)) (self sel_145:))
				)
			)
			(
				(and
					sel_139
					(<=
						(= sel_139 (- sel_139 (Abs (- gSel_45 sel_140))))
						0
					)
				)
				(= sel_139 0)
				(self sel_145:)
			)
		)
		(= sel_140 gSel_45)
	)
	
	(method (sel_111 &tmp temp0)
		(if (IsObject sel_142) (sel_142 sel_111:))
		(if (IsObject sel_135) (sel_135 sel_111:))
		(if (IsObject sel_42)
			(sel_42
				sel_142:
					(= temp0
						(cond 
							((IsObject sel_65) sel_65)
							(sel_65 (ScriptID sel_65))
						)
					)
			)
			(cond 
				((not temp0) 0)
				((== gTheGSel_40 gSel_40) (temp0 sel_110: sel_42))
				(else (temp0 sel_111:))
			)
		)
		(if
		(and (IsObject sel_143) (== gTheGSel_40 gSel_40))
			(sel_143 sel_145: sel_141)
		)
		(= sel_142
			(= sel_135 (= sel_42 (= sel_65 (= sel_143 0))))
		)
		(super sel_111:)
	)
	
	(method (sel_144 theSel_29)
		(= sel_29 theSel_29)
	)
	
	(method (sel_145)
		(if sel_42 (self sel_144: (+ sel_29 1) &rest))
	)
	
	(method (sel_133 param1)
		(if sel_142 (sel_142 sel_133: param1))
		(param1 sel_73?)
	)
	
	(method (sel_146 param1)
		(if (IsObject sel_142) (sel_142 sel_111:))
		(if param1 (param1 sel_110: self &rest))
	)
)

(class Event of Obj
	(properties
		sel_20 {Event}
		sel_31 0
		sel_37 0
		sel_61 0
		sel_0 0
		sel_1 0
		sel_73 0
		sel_147 0
	)
	
	(method (sel_109 param1 &tmp superSel_109)
		(= superSel_109 (super sel_109:))
		(GetEvent (if argc param1 else 32767) superSel_109)
		(return superSel_109)
	)
	
	(method (sel_148 &tmp theSel_147)
		(if (not (& sel_31 $4000))
			(= theSel_147 (GetPort))
			(cond 
				((not sel_147) (GlobalToLocal self))
				((!= sel_147 theSel_147)
					(SetPort sel_147)
					(LocalToGlobal self)
					(SetPort theSel_147)
					(GlobalToLocal self)
				)
			)
			(= sel_147 theSel_147)
		)
		(return self)
	)
	
	(method (sel_149 &tmp temp0)
		(if (not (& sel_31 $4000))
			(cond 
				((== sel_147 (= temp0 (GetPort))) (LocalToGlobal self))
				(sel_147 (SetPort sel_147) (LocalToGlobal self) (SetPort temp0))
			)
			(= sel_147 0)
		)
		(return self)
	)
)

(class Cursor of Obj
	(properties
		sel_20 {Cursor}
		sel_2 0
		sel_3 0
		sel_4 0
		sel_1 0
		sel_0 0
		sel_150 0
		sel_151 0
		sel_152 0
	)
	
	(method (sel_110)
		(if (or sel_150 sel_151)
			(SetCursor sel_2 sel_3 sel_4 sel_150 sel_151)
		else
			(SetCursor sel_2 sel_3 sel_4)
		)
	)
	
	(method (sel_153 param1 param2)
		(SetCursor param1 param2)
	)
	
	(method (sel_154 theSel_150 theSel_151)
		(= sel_150 theSel_150)
		(= sel_151 theSel_151)
		(self sel_110:)
	)
	
	(method (sel_155 theSel_3)
		(= sel_3 theSel_3)
		(self sel_110:)
	)
	
	(method (sel_156 theSel_4)
		(= sel_4 theSel_4)
		(self sel_110:)
	)
	
	(method (sel_157 param1)
		(if argc (SetCursor param1))
	)
)
