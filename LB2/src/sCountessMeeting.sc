;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 441)
(include sci.sh)
(use Main)
(use PolyPath)
(use Timer)
(use Motion)
(use System)

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

	(method (sel_144 param1)
		(switch (= sel_29 param1)
			(0
				(= sel_136 3)
			)
			(1
				(= sel_136 1)
			)
			(2
				(self sel_146: sCountessEnters self)
			)
			(3
				((ScriptID 90 1) sel_312: PolyPath 141 171 self) ; aCountess
			)
			(4
				((ScriptID 90 1) sel_2: 444 sel_3: 0 sel_4: 0) ; aCountess
				(gGame sel_588:)
				(if (== (gEgo sel_2:) 443)
					(gTheIconBar sel_233: 1 2 5 6)
				)
				(gTheIconBar sel_177: 7)
				(= sel_136 1)
			)
			(5
				(= sel_137 10)
			)
			(6
				(if (== (gEgo sel_2:) 443)
					(gTheIconBar sel_233: 1 2 5 6)
				)
				(gGame sel_587:)
				(= sel_136 3)
			)
			(7
				(if (== (gEgo sel_2:) 443)
					((ScriptID 90 1) sel_161: End self) ; aCountess
				else
					(gGame sel_588: 1)
					(self sel_111:)
				)
			)
			(8
				(= sel_137 2)
			)
			(9
				((ScriptID 90 1) sel_161: Beg self) ; aCountess
			)
			(10
				(= sel_137 3)
			)
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

	(method (sel_144 param1)
		(switch (= sel_29 param1)
			(0
				(= sel_136 3)
			)
			(1
				(= sel_136 1)
			)
			(2
				(self sel_146: sCountessEnters self)
			)
			(3
				(if (and (gEgo sel_238: 7) (not (IsFlag 120)))
					(gEgo sel_146: sTalkWithCountess)
					(self sel_111:)
				else
					(= sel_137 2)
				)
			)
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

	(method (sel_144 param1)
		(switch (= sel_29 param1)
			(0
				((ScriptID 90 1) ; aCountess
					sel_182: 440
					sel_3: 1
					sel_1: 240
					sel_0: 134
					sel_299: askQuestions
				)
				(if ((ScriptID 90 1) sel_322:) ; aCountess
					(((ScriptID 90 1) sel_322:) sel_57:) ; aCountess
				)
				(= sel_136 1)
			)
			(1
				((ScriptID 90 1) sel_2: 825) ; aCountess
				(if (== ((ScriptID 440 2) sel_29:) 0) ; rm440Door
					((ScriptID 440 2) sel_143: self sel_189:) ; rm440Door
				else
					(= sel_136 1)
				)
			)
			(2
				((ScriptID 90 1) sel_312: PolyPath 122 154 self) ; aCountess
			)
			(3
				(self sel_111:)
			)
		)
	)
)

(instance sCountessLeaves of Script
	(properties
		sel_20 {sCountessLeaves}
	)

	(method (sel_144 param1)
		(switch (= sel_29 param1)
			(0
				(if (== (gEgo sel_2:) 443)
					(gTheIconBar sel_233: 1 2 5 6)
				else
					(gWalkHandler sel_81: gCurRoom)
					(gDirectionHandler sel_81: gCurRoom)
				)
				(gGame sel_587:)
				(= sel_136 1)
			)
			(1
				((ScriptID 90 1) ; aCountess
					sel_2: 825
					sel_161: Walk
					sel_312: PolyPath 122 154 self
				)
			)
			(2
				((ScriptID 90 1) sel_312: PolyPath 210 145 self) ; aCountess
			)
			(3
				(if (== ((ScriptID 440 2) sel_29:) 0) ; rm440Door
					((ScriptID 440 2) sel_143: self sel_189:) ; rm440Door
				else
					(= sel_136 1)
				)
			)
			(4
				((ScriptID 90 1) sel_312: PolyPath 239 134 self) ; aCountess
			)
			(5
				((ScriptID 440 2) sel_143: self sel_360:) ; rm440Door
			)
			(6
				(if (== (gEgo sel_2:) 443)
					(gGame sel_588: 1)
					(gUser sel_237: 1)
				else
					(gGame sel_588:)
				)
				((ScriptID 90 1) sel_299: 0 sel_182: 430 sel_619: 1) ; aCountess
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

	(method (sel_144 param1)
		(switch (= sel_29 param1)
			(0
				(gEgo sel_312: PolyPath 100 172 self)
			)
			(1
				(gMessager sel_295: 1 0 1 0 self 1440)
			)
			(2
				(SetFlag 120)
				(countTimer sel_162: countTimer 15)
				(gGame sel_588: 1)
				(gTheIconBar sel_177: 1 2 5 6)
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
		(return
			(switch param1
				(6
					(if (== (gEgo sel_2:) 443)
						(gCurRoom sel_146: (ScriptID 440 1)) ; sOutTapestry
					else
						(switch (gCurRoom sel_422: (ScriptID 20 0)) ; inNotebook
							(1030
								(gMessager sel_295: 1 6 2 0 0 1440)
								(countTimer
									sel_137: (+ (countTimer sel_137:) 10)
								)
							)
							(else
								(gMessager sel_295: 1 6 4 0 0 1440)
								(countTimer sel_137: 1)
							)
						)
					)
					1
				)
				(2
					(if (== (gEgo sel_2:) 443)
						(gCurRoom sel_146: (ScriptID 440 1)) ; sOutTapestry
					else
						(gMessager sel_295: 1 2 0 0 0 1440)
					)
					1
				)
				(17
					(if (== (gEgo sel_2:) 443)
						(gCurRoom sel_146: (ScriptID 440 1)) ; sOutTapestry
					else
						(gMessager sel_295: 1 17 0 0 0 1440)
						(countTimer sel_137: (+ (countTimer sel_137:) 10))
					)
					1
				)
				(else 0)
			)
		)
	)
)

(instance countTimer of Timer
	(properties
		sel_20 {countTimer}
	)

	(method (sel_145)
		(cond
			((not ((ScriptID 90 1) sel_56:)) ; aCountess
				((ScriptID 90 1) sel_146: sCountessLeaves) ; aCountess
			)
			(((ScriptID 90 1) sel_142:) ; aCountess
				(((ScriptID 90 1) sel_142:) sel_65: sCountessLeaves) ; aCountess
			)
		)
	)
)
