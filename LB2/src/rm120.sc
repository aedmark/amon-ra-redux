;;; Sierra Script 1.0 - (do not remove this comment)
(script# 120)
(include sci.sh)
(use Main)
(use LBRoom)
(use n958)
(use Cycle)
(use View)
(use Obj)

(public
	rm120 0
)

(instance rm120 of LBRoom
	(properties
		sel_20 {rm120}
		sel_408 120
		sel_28 10
	)
	
	(method (sel_110)
		(proc958_0 128 131 121 130)
		(proc958_0 132 120 121)
		(self sel_414: 92)
		(super sel_110:)
		(person1 sel_110: sel_320: 122)
		(person2 sel_110: sel_320: 122)
		(gSel_608 sel_40: 120 sel_99: 1 sel_3: -1 sel_39:)
		(global2 sel_146: sIntroScript)
	)
	
	(method (sel_111)
		(gSel_608 sel_170: 0 30 12 1)
		(super sel_111: &rest)
	)
)

(instance moveIt of Script
	(properties
		sel_20 {moveIt}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(= sel_139 sel_141)
				(= sel_141 0)
			)
			(1
				(sel_42 sel_312: MoveTo 194 127 self)
			)
			(2
				(sel_42 sel_3: (Random 0 4) sel_153: 169 121)
				(= sel_139 (Random 12 60))
				(++ sel_141)
			)
			(3
				(if (< sel_141 3)
					(self sel_144: 1)
				else
					(self sel_111:)
				)
			)
		)
	)
)

(instance sIntroScript of Script
	(properties
		sel_20 {sIntroScript}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(= sel_136 2)
				(person1 sel_320:)
				(person2 sel_320:)
			)
			(1
				(person1 sel_146: (moveIt sel_109:) self 60)
				(person2 sel_146: (moveIt sel_109:) self 90)
			)
			(2 0)
			(3
				(person1 sel_111:)
				(person2 sel_111:)
				(= sel_136 2)
			)
			(4
				(closeUpView sel_110:)
				(gangplankBG sel_110:)
				(= sel_136 1)
			)
			(5
				(global2 sel_146: sCloseUp)
				(self sel_111:)
			)
		)
	)
)

(instance sCloseUp of Script
	(properties
		sel_20 {sCloseUp}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(closeUpView sel_313:)
				(person1
					sel_110:
					sel_2: 131
					sel_153: 78 82
					sel_51: 5
					sel_52: 2
					sel_63: 8
					sel_3: 3
					sel_53: 16
					sel_161: Walk
				)
				(person2
					sel_110:
					sel_2: 131
					sel_153: 48 72
					sel_51: 5
					sel_52: 2
					sel_63: 8
					sel_3: 2
					sel_53: 16
					sel_161: Walk
				)
				((ScriptID 1882 10)
					sel_203: 1
					sel_291: 0
					sel_1: 224
					sel_0: 21
					sel_549: -214
					sel_550: 121
					sel_537: 284
				)
				((ScriptID 1883 9)
					sel_203: 1
					sel_291: 0
					sel_1: 3
					sel_0: 2
					sel_549: 7
					sel_550: 140
					sel_537: 284
				)
				(self sel_146: sDisembark self 1)
			)
			(1
				((ScriptID 1887 12)
					sel_203: 1
					sel_291: 0
					sel_1: 224
					sel_0: 21
					sel_549: -214
					sel_550: 121
					sel_537: 284
				)
				((ScriptID 1886 11)
					sel_203: 1
					sel_291: 0
					sel_1: 4
					sel_0: 22
					sel_549: 7
					sel_550: 120
					sel_537: 284
				)
				(person1
					sel_110:
					sel_2: 131
					sel_153: 78 82
					sel_51: 5
					sel_52: 2
					sel_63: 8
					sel_3: 0
					sel_53: 16
					sel_161: Walk
				)
				(person2
					sel_110:
					sel_2: 131
					sel_153: 48 72
					sel_51: 5
					sel_52: 2
					sel_63: 8
					sel_3: 1
					sel_53: 16
					sel_161: Walk
				)
				(= sel_136 2)
			)
			(2
				(self sel_146: sDisembark self 0)
			)
			(3
				(global2 sel_399: 140)
				(self sel_111:)
			)
		)
	)
)

(instance sDisembark of Script
	(properties
		sel_20 {sDisembark}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0 (= sel_136 2))
			(1
				(if sel_141
					(person1 sel_312: MoveTo 168 110)
				else
					(person1 sel_312: MoveTo 159 114)
				)
				(person2 sel_312: MoveTo 138 100 self)
			)
			(2
				(if sel_141
					(person1 sel_3: 4 sel_161: End self)
					(person2 sel_161: 0)
				else
					(= sel_136 2)
				)
			)
			(3
				(gLb2Messager sel_295: (if sel_141 1 else 2) 0 0 0 self)
			)
			(4
				(if sel_141
					(person1 sel_161: Beg self)
				else
					(++ sel_29)
					(= sel_136 2)
				)
			)
			(5
				(person1 sel_3: 3 sel_161: Walk)
				(= sel_136 2)
			)
			(6
				(person1 sel_312: MoveTo 211 134 self)
				(if (not sel_141)
					(person2 sel_312: MoveTo 181 118 self)
				else
					(= sel_136 2)
				)
			)
			(7 0)
			(8
				(person1 sel_111:)
				(person2 sel_161: Walk sel_312: MoveTo 217 128 self)
			)
			(9 (self sel_111:))
		)
	)
)

(instance person1 of Actor
	(properties
		sel_20 {person1}
		sel_1 169
		sel_0 121
		sel_2 121
		sel_60 3
		sel_14 18448
		sel_53 10
	)
)

(instance person2 of Actor
	(properties
		sel_20 {person2}
		sel_1 169
		sel_0 121
		sel_2 121
		sel_3 1
		sel_60 3
		sel_14 18448
		sel_53 10
	)
)

(instance gangplankBG of View
	(properties
		sel_20 {gangplankBG}
		sel_1 107
		sel_0 42
		sel_2 130
		sel_60 8
		sel_14 16400
	)
)

(instance closeUpView of View
	(properties
		sel_20 {closeUpView}
		sel_1 85
		sel_0 25
		sel_2 130
		sel_4 1
		sel_60 9
		sel_14 16400
	)
)
