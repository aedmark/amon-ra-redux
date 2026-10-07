;;; Sierra Script 1.0 - (do not remove this comment)
(script# 441)
(include sci.sh)
(use Main)
(use PolyPath)
(use Timer)
(use Cycle)
(use Obj)

(public
	sCountessMeeting 0
	sCountessNoMeet 1
	sCountessLeaves 2
	sTalkWithCountess 3
	countTimer 4
)

(instance sCountessMeeting of Script
	(properties
		sel_20 {sCountessMeeting}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0 (= sel_136 3))
			(1 (= sel_136 1))
			(2
				(self sel_146: sCountessEnters self)
			)
			(3
				((ScriptID 90 1) sel_312: PolyPath 141 171 self)
			)
			(4
				((ScriptID 90 1) sel_2: 444 sel_3: 0 sel_4: 0)
				(gGame sel_588:)
				(if (== (gEgo sel_2?) 443) (gIconBar sel_233: 1 2 5 6))
				(gIconBar sel_177: 7)
				(= sel_136 1)
			)
			(5 (= sel_137 10))
			(6
				(if (== (gEgo sel_2?) 443) (gIconBar sel_233: 1 2 5 6))
				(gGame sel_587:)
				(= sel_136 3)
			)
			(7
				(if (== (gEgo sel_2?) 443)
					((ScriptID 90 1) sel_161: End self)
				else
					(gGame sel_588: 1)
					(self sel_111:)
				)
			)
			(8 (= sel_137 2))
			(9
				((ScriptID 90 1) sel_161: Beg self)
			)
			(10 (= sel_137 3))
			(11
				(gGame sel_588: 1)
				(sel_42 sel_146: sCountessLeaves)
			)
		)
	)
)

(instance sCountessNoMeet of Script
	(properties
		sel_20 {sCountessNoMeet}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0 (= sel_136 3))
			(1 (= sel_136 1))
			(2
				(self sel_146: sCountessEnters self)
			)
			(3 (= sel_137 2))
			(4
				(sel_42 sel_146: sCountessLeaves)
			)
		)
	)
)

(instance sCountessEnters of Script
	(properties
		sel_20 {sCountessEnters}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				((ScriptID 90 1)
					sel_182: 440
					sel_3: 1
					sel_1: 240
					sel_0: 134
					sel_299: askQuestions
				)
				(if ((ScriptID 90 1) sel_322?)
					(((ScriptID 90 1) sel_322?) sel_57:)
				)
				(= sel_136 1)
			)
			(1
				((ScriptID 90 1) sel_2: 825)
				(if (== ((ScriptID 440 2) sel_29?) 0)
					((ScriptID 440 2) sel_143: self sel_189:)
				else
					(= sel_136 1)
				)
			)
			(2
				((ScriptID 90 1) sel_312: PolyPath 122 154 self)
			)
			(3 (self sel_111:))
		)
	)
)

(instance sCountessLeaves of Script
	(properties
		sel_20 {sCountessLeaves}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(if (== (gEgo sel_2?) 443)
					(gIconBar sel_233: 1 2 5 6)
				else
					(gLb2WH sel_81: global2)
					(gLb2DH sel_81: global2)
				)
				(gGame sel_587:)
				(= sel_136 1)
			)
			(1
				((ScriptID 90 1)
					sel_2: 825
					sel_161: Walk
					sel_312: PolyPath 122 154 self
				)
			)
			(2
				((ScriptID 90 1) sel_312: PolyPath 210 145 self)
			)
			(3
				(if (== ((ScriptID 440 2) sel_29?) 0)
					((ScriptID 440 2) sel_143: self sel_189:)
				else
					(= sel_136 1)
				)
			)
			(4
				((ScriptID 90 1) sel_312: PolyPath 239 134 self)
			)
			(5
				((ScriptID 440 2) sel_143: self sel_360:)
			)
			(6
				(if (== (gEgo sel_2?) 443)
					(gGame sel_588: 1)
					(gUser sel_237: 1)
				else
					(gGame sel_588:)
				)
				((ScriptID 90 1) sel_299: 0 sel_182: 430 sel_619: 1)
				(countTimer sel_111:)
				(gGameMusic2 sel_170:)
				(WrapMusic sel_168: 0)
				(self sel_111:)
				(DisposeScript 441)
			)
		)
	)
)

(instance sTalkWithCountess of Script
	(properties
		sel_20 {sTalkWithCountess}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gEgo sel_312: PolyPath 100 172 self)
			)
			(1
				(gLb2Messager sel_295: 1 0 1 0 self 1440)
			)
			(2
				(proc0_3 120)
				(countTimer sel_162: countTimer 15)
				(gGame sel_588: 1)
				(gIconBar sel_177: 1 2 5 6)
				(self sel_111:)
			)
		)
	)
)

(instance askQuestions of Actions
	(properties
		sel_20 {askQuestions}
	)
	
	(method (sel_300 param1)
		(switch param1
			(6
				(if (== (gEgo sel_2?) 443)
					(global2 sel_146: (ScriptID 440 1))
				else
					(switch (global2 sel_422: (ScriptID 20 0))
						(1030
							(gLb2Messager sel_295: 1 6 2 0 0 1440)
							(countTimer sel_137: (+ (countTimer sel_137?) 10))
						)
						(else 
							(gLb2Messager sel_295: 1 6 4 0 0 1440)
							(countTimer sel_137: 1)
						)
					)
				)
				1
			)
			(2
				(if (== (gEgo sel_2?) 443)
					(global2 sel_146: (ScriptID 440 1))
				else
					(gLb2Messager sel_295: 1 2 0 0 0 1440)
				)
			)
			(17
				(gLb2Messager sel_295: 1 17 0 0 0 1440)
				(countTimer sel_137: (+ (countTimer sel_137?) 10))
			)
			(else  0)
		)
	)
)

(instance countTimer of Timer
	(properties
		sel_20 {countTimer}
	)
	
	(method (sel_145)
		(cond 
			((not ((ScriptID 90 1) sel_56?)) ((ScriptID 90 1) sel_146: sCountessLeaves))
			(((ScriptID 90 1) sel_142?) (((ScriptID 90 1) sel_142?) sel_65: sCountessLeaves))
		)
	)
)
