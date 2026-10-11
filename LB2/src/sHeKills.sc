;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 444)
(include sci.sh)
(use Main)
(use Scaler)
(use PolyPath)
(use Motion)
(use Actor)
(use System)

(public
	sHeKills 0
)

(instance sHeKills of Script
	(properties
		sel_20 {sHeKills}
	)

	(method (sel_144 param1)
		(switch (= sel_29 param1)
			(0
				(if (== (gEgo sel_2:) 443)
					(gTheIconBar sel_233: 0 3 4)
				)
				(gGame sel_587:)
				(= sel_136 1)
			)
			(1
				(cond
					((and (IsFlag 41) (not (IsFlag 47)))
						(self sel_146: sSmashedDoorOpen self)
					)
					((and (== ((ScriptID 440 2) sel_29:) 0) (not (IsFlag 47))) ; rm440Door
						((ScriptID 440 2) sel_143: self sel_189:) ; rm440Door
					)
					(else
						(= sel_136 1)
					)
				)
			)
			(2
				(if (IsFlag 47)
					(oriley sel_153: 160 250)
				)
				(oriley sel_110: sel_161: Walk sel_320: Scaler 155 0 190 90)
				(= sel_136 3)
			)
			(3
				(cond
					((IsFlag 47)
						(self sel_146: sKillFromSouth self)
					)
					((== (gEgo sel_2:) 443)
						(gGameMusic1 sel_40: 3 sel_3: 1 sel_99: 1 sel_39:)
						(oriley sel_63: -1 sel_312: PolyPath 20 150 self)
					)
					(else
						(self sel_146: sKillFromEast self)
					)
				)
			)
			(4
				(oriley sel_2: 424 sel_4: 0 sel_161: End self)
			)
			(5
				((ScriptID 440 3) sel_40: 80 sel_99: 5 sel_39:) ; noise
				(gEgo sel_2: 858 sel_161: End self)
			)
			(6
				(if (and (== (gEgo sel_2:) 443) (gWalkHandler sel_122: gCurRoom))
					(gWalkHandler sel_81: gCurRoom)
				)
				(= global145 0) ; "You came in thinking like a journalist, and you left with a skull full of mush."
				(gCurRoom sel_399: 99)
				(self sel_111:)
			)
		)
	)
)

(instance sKillFromSouth of Script
	(properties
		sel_20 {sKillFromSouth}
	)

	(method (sel_144 param1)
		(switch (= sel_29 param1)
			(0
				(gGame sel_587:)
				(= sel_136 1)
			)
			(1
				(gEgo sel_312: PolyPath 198 166 self)
			)
			(2
				(gGameMusic1 sel_40: 3 sel_3: 1 sel_99: 1 sel_39:)
				(oriley sel_312: MoveTo 174 174 self)
			)
			(3
				(self sel_111:)
			)
		)
	)
)

(instance sKillFromEast of Script
	(properties
		sel_20 {sKillFromEast}
	)

	(method (sel_144 param1)
		(switch (= sel_29 param1)
			(0
				(gGame sel_587:)
				(= sel_136 1)
			)
			(1
				(gEgo sel_312: PolyPath 93 155 self)
			)
			(2
				(gGameMusic1 sel_40: 3 sel_3: 1 sel_99: 1 sel_39:)
				(oriley sel_312: MoveTo 119 153 self)
			)
			(3
				(self sel_111:)
			)
		)
	)
)

(instance sSmashedDoorOpen of Script
	(properties
		sel_20 {sSmashedDoorOpen}
	)

	(method (sel_144 param1)
		(switch (= sel_29 param1)
			(0
				(shavings sel_110: sel_155: 7)
				(= sel_136 1)
			)
			(1
				((ScriptID 440 3) sel_40: 444 sel_3: 1 sel_99: 5 sel_39:) ; noise
				(shavings sel_161: End self)
			)
			(2
				(gMessager sel_295: 37 0 5 0 self)
			)
			(3
				(shavings
					sel_4: 0
					sel_153: (- (shavings sel_1:) 2) (- (shavings sel_0:) 1)
				)
				(= sel_136 1)
			)
			(4
				((ScriptID 440 3) sel_40: 444 sel_3: 1 sel_99: 5 sel_39:) ; noise
				(shavings sel_161: End self)
			)
			(5
				((ScriptID 440 3) sel_40: 444 sel_3: 1 sel_99: 5 sel_39:) ; noise
				(shavings sel_161: End self)
				((ScriptID 440 2) sel_590: 0 sel_189:) ; rm440Door
				((ScriptID 440 4) sel_161: Beg) ; bolt
			)
			(6
				(shavings sel_317:)
				(self sel_111:)
			)
		)
	)
)

(instance oriley of Actor
	(properties
		sel_20 {oriley}
		sel_1 233
		sel_0 135
		sel_2 423
	)
)

(instance shavings of Prop
	(properties
		sel_20 {shavings}
		sel_1 220
		sel_0 142
		sel_2 440
		sel_3 7
		sel_14 16384
	)
)
