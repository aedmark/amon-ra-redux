;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 448)
(include sci.sh)
(use Main)
(use Door)
(use eRS)
(use ExitFeature)
(use PursuitRgn)
(use PChase)
(use Scaler)
(use PolyPath)
(use Feature)
(use MoveFwd)
(use LoadMany)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm448 0
)

(local
	local0
)

(instance rm448 of LBRoom
	(properties
		sel_20 {rm448}
		sel_213 14
		sel_408 448
		sel_409 450
		sel_411 440
		sel_412 460
		sel_107 150
		sel_108 35
	)

	(method (sel_110)
		(LoadMany rsVIEW 449 440 424 423 448 426 831)
		(LoadMany rsSOUND 444 443 445)
		(gEgo
			sel_110:
			sel_585: (if (== gAct 5) 426 else 831)
			sel_320: Scaler 138 0 190 35
		)
		(if (== gAct 5)
			(self sel_414: 94)
			(gCurRoom sel_259: (List sel_109:))
			((ScriptID 2448 0) sel_57: (gCurRoom sel_259:)) ; poly2448Code
		else
			(self sel_414: 90)
		)
		(switch gPrevRoomNum
			(sel_409
				(gEgo sel_1: 140 sel_0: 111)
				(self sel_146: sEnterNorth)
			)
			(sel_411
				(gEgo sel_1: 151 sel_0: 162 sel_349: 0 sel_253: 0)
				(self sel_146: sEnterSouth)
			)
			(sel_412
				(gEgo sel_1: 85 sel_0: 130 sel_349: 0 sel_253: 90)
				(gGame sel_588:)
			)
			(else
				(gEgo sel_153: 146 130)
				(gGame sel_588:)
			)
		)
		(super sel_110:)
		(if (== gAct 5)
			(if (or (IsFlag 39) (IsFlag 116))
				(chair sel_63: 7 sel_153: 104 123)
				(transomWin sel_4: 3)
			)
			(chair sel_110: sel_313:)
		)
		(transomWin sel_110: sel_313:)
		(if (IsFlag 47)
			(westNoDoor sel_110:)
		else
			(transomDoor sel_110: sel_311: 4 1 8)
		)
		(flag4 sel_110:)
		(flag5 sel_110:)
		(flag6 sel_110:)
		(flag7 sel_110:)
		(armor4 sel_110:)
		(armor7 sel_110:)
		(armor8 sel_110:)
		(rearDoorway sel_110:)
		(southExitFeature sel_110:)
	)

	(method (sel_57)
		(super sel_57:)
		(cond
			(sel_142)
			((StepOn gEgo 2)
				(gEgo sel_349: 4)
				(self sel_399: sel_412)
			)
			((StepOn gEgo 8)
				(self sel_399: sel_409)
			)
		)
	)

	(method (sel_111)
		(DisposeScript 2448)
		(gWalkHandler sel_81: gCurRoom)
		(gDirectionHandler sel_81: gCurRoom)
		(super sel_111:)
	)

	(method (sel_133 param1)
		(cond
			(
				(and
					(& (param1 sel_31:) $0040)
					(== (gTheIconBar sel_207:) (gTheIconBar sel_228:))
					(!= (param1 sel_37:) 0)
				)
				(param1 sel_73: 1)
				(gCurRoom sel_146: sOffChair)
			)
			((& (param1 sel_31:) $1000)
				(super sel_133: param1)
			)
		)
	)

	(method (sel_300 param1)
		(switch param1
			(3
				(gCurRoom sel_146: sOffChair)
			)
			(else
				(super sel_300: param1 &rest)
			)
		)
	)

	(method (sel_403)
		(if (== gAct 5)
			(if (gCurRoom sel_142:)
				((gCurRoom sel_142:) sel_65: sHeKills)
			else
				(gCurRoom sel_146: sHeKills)
			)
		)
	)
)

(instance sEnterWest of Script ; UNUSED
	(properties
		sel_20 {sEnterWest}
	)

	(method (sel_144 param1)
		(switch (= sel_29 param1)
			(0
				(gGame sel_587:)
				(= sel_136 1)
			)
			(1
				(gEgo
					sel_1: 230
					sel_0: 140
					sel_349: 0
					sel_312: MoveFwd 20 self
				)
			)
			(2
				(gGame sel_588:)
				(self sel_111:)
			)
		)
	)
)

(instance sEnterNorth of Script
	(properties
		sel_20 {sEnterNorth}
	)

	(method (sel_144 param1)
		(switch (= sel_29 param1)
			(0
				(gGame sel_587:)
				(= sel_136 1)
			)
			(1
				(gEgo sel_349: 0 sel_253: 180 sel_312: MoveFwd 10 self)
			)
			(2
				(if (and (not (IsFlag 39)) (== gAct 5))
					((ScriptID 94 1) sel_145:) ; pursuitTimer
				)
				(gGame sel_588:)
				(self sel_111:)
			)
		)
	)
)

(instance sEnterSouth of Script
	(properties
		sel_20 {sEnterSouth}
	)

	(method (sel_144 param1)
		(switch (= sel_29 param1)
			(0
				(gGame sel_587:)
				(= sel_136 1)
			)
			(1
				(gEgo sel_312: MoveFwd 20 self)
			)
			(2
				(gGame sel_588:)
				(self sel_111:)
			)
		)
	)
)

(instance sHeKills of Script
	(properties
		sel_20 {sHeKills}
	)

	(method (sel_144 param1)
		(switch (= sel_29 param1)
			(0
				(gGame sel_587:)
				(= sel_136 1)
			)
			(1
				(if local0
					(self sel_146: sOffChair self)
				else
					(= sel_136 1)
				)
			)
			(2
				(gGame sel_587:)
				(= sel_136 1)
			)
			(3
				(gEgo sel_312: PolyPath 149 128 self)
			)
			(4
				(gGameMusic1 sel_40: 3 sel_3: 1 sel_99: 1 sel_39:)
				(oriley sel_110: sel_320: Scaler 138 0 190 35)
				(= sel_136 1)
			)
			(5
				(oriley sel_161: Walk sel_312: PChase gEgo 12 self)
			)
			(6
				(Face gEgo oriley)
				(= sel_136 2)
			)
			(7
				(oriley sel_2: 424 sel_4: 0 sel_161: End self)
			)
			(8
				(noise sel_40: 80 sel_99: 5 sel_39:)
				(gEgo sel_2: 858 sel_161: End self)
			)
			(9
				(= global145 0) ; "You came in thinking like a journalist, and you left with a skull full of mush."
				(gCurRoom sel_399: 99)
				(self sel_111:)
			)
		)
	)
)

(instance sMoveChair of Script
	(properties
		sel_20 {sMoveChair}
	)

	(method (sel_144 param1)
		(switch (= sel_29 param1)
			(0
				(gGame sel_587:)
				(= sel_136 1)
			)
			(1
				(gEgo sel_316: 1 sel_15: 0)
				(= sel_136 1)
			)
			(2
				(if (StepOn gEgo 16)
					(gEgo sel_312: MoveTo 112 135 self)
				else
					(gEgo sel_312: PolyPath 112 135 self)
				)
			)
			(3
				(= local0 1)
				(gEgo
					sel_2: 449
					sel_3: 0
					sel_4: 0
					sel_153: 112 133
					sel_316: 0
					sel_15: -32768
					sel_161: End self
				)
				(chair
					sel_316: 1
					sel_155: 2
					sel_53: (+ (gEgo sel_53:) 4)
					sel_312: MoveTo 104 123 self
				)
				(noise sel_40: 443 sel_99: 5 sel_39:)
			)
			(4 0)
			(5
				(gEgo
					sel_585: (if (== gAct 5) 426 else 831)
					sel_320: Scaler 138 0 190 35
					sel_312: MoveTo 121 122 self
				)
			)
			(6
				(gEgo
					sel_2: 449
					sel_3: 1
					sel_4: 0
					sel_153: 107 124
					sel_63: 9
					sel_161: End self
				)
				(chair sel_63: 7 sel_313:)
				(gWalkHandler sel_129: gCurRoom)
				(gDirectionHandler sel_129: gCurRoom)
			)
			(7
				(gGame sel_588:)
				(transomDoor sel_311: 0)
				(SetFlag 116)
				(southExitFeature sel_111:)
				(rearDoorway sel_301: 26505)
				(armor4 sel_301: 26505)
				(armor7 sel_301: 26505)
				(armor8 sel_301: 26505)
				(flag4 sel_301: 26505)
				(flag5 sel_301: 26505)
				(flag6 sel_301: 26505)
				(flag7 sel_301: 26505)
				(self sel_111:)
			)
		)
	)
)

(instance sOnChair of Script
	(properties
		sel_20 {sOnChair}
	)

	(method (sel_144 param1)
		(switch (= sel_29 param1)
			(0
				(gGame sel_587:)
				(= sel_136 1)
			)
			(1
				(gEgo sel_316: 1 sel_15: 0)
				(= sel_136 1)
			)
			(2
				(if (StepOn gEgo 16)
					(gEgo sel_312: MoveTo 121 122 self)
				else
					(gEgo sel_312: PolyPath 121 122 self)
				)
			)
			(3
				(gEgo
					sel_2: 449
					sel_3: 1
					sel_4: 0
					sel_153: 107 124
					sel_63: 9
					sel_316: 0
					sel_15: -32768
					sel_161: End self
				)
			)
			(4
				(gGame sel_588:)
				(transomDoor sel_311: 0)
				(= local0 1)
				(southExitFeature sel_111:)
				(gWalkHandler sel_129: gCurRoom)
				(gDirectionHandler sel_129: gCurRoom)
				(rearDoorway sel_301: 26505)
				(armor4 sel_301: 26505)
				(armor7 sel_301: 26505)
				(armor8 sel_301: 26505)
				(flag4 sel_301: 26505)
				(flag5 sel_301: 26505)
				(flag6 sel_301: 26505)
				(flag7 sel_301: 26505)
				(self sel_111:)
			)
		)
	)
)

(instance sOffChair of Script
	(properties
		sel_20 {sOffChair}
	)

	(method (sel_144 param1)
		(switch (= sel_29 param1)
			(0
				(gGame sel_587:)
				(= sel_136 1)
			)
			(1
				(gEgo
					sel_2: 449
					sel_3: 1
					sel_4: 8
					sel_153: 107 124
					sel_63: 10
					sel_161: Beg self
				)
			)
			(2
				(gEgo
					sel_585: (if (== gAct 5) 426 else 831)
					sel_153: 121 122
					sel_320: Scaler 138 0 190 35
				)
				(= local0 0)
				(gGame sel_588:)
				(transomDoor sel_311: 4 1 8)
				(southExitFeature sel_110:)
				(gWalkHandler sel_81: gCurRoom)
				(gDirectionHandler sel_81: gCurRoom)
				(rearDoorway sel_301: 40)
				(armor4 sel_301: 40)
				(armor7 sel_301: 40)
				(armor8 sel_301: 40)
				(flag4 sel_301: 40)
				(flag5 sel_301: 40)
				(flag6 sel_301: 40)
				(flag7 sel_301: 40)
				(self sel_111:)
			)
		)
	)
)

(instance sOpenTransom of Script
	(properties
		sel_20 {sOpenTransom}
	)

	(method (sel_144 param1)
		(switch (= sel_29 param1)
			(0
				(if local0
					(= sel_136 1)
				else
					(self sel_146: sOnChair self)
				)
			)
			(1
				(gEgo
					sel_3: 2
					sel_4: 0
					sel_153: 104 112
					sel_316: 1
					sel_15: 0
					sel_161: CT 6 1 self
				)
			)
			(2
				(gEgo sel_161: End self)
				(transomWin sel_161: End)
				(noise sel_40: 445 sel_99: 5 sel_39:)
			)
			(3
				(gEgo sel_4: 0)
				(transomWin sel_313:)
				(= sel_136 1)
			)
			(4
				(SetFlag 39)
				(PursuitRgn sel_669:)
				(gGame sel_588:)
				(self sel_111:)
			)
		)
	)
)

(instance sCloseTransom of Script
	(properties
		sel_20 {sCloseTransom}
	)

	(method (sel_144 param1)
		(switch (= sel_29 param1)
			(0
				(if local0
					(= sel_136 1)
				else
					(self sel_146: sOnChair self)
				)
			)
			(1
				(gEgo
					sel_3: 2
					sel_4: 9
					sel_316: 1
					sel_15: 0
					sel_153: 104 112
					sel_161: CT 6 -1 self
				)
			)
			(2
				(gEgo sel_161: Beg self)
				(transomWin sel_161: Beg)
				(noise sel_40: 445 sel_99: 5 sel_39:)
			)
			(3
				(ClearFlag 39)
				(transomWin sel_313:)
				(PursuitRgn sel_670:)
				(gGame sel_588:)
				(self sel_111:)
			)
		)
	)
)

(instance oriley of Actor
	(properties
		sel_20 {oriley}
		sel_1 171
		sel_0 199
		sel_2 423
	)
)

(instance chair of Actor
	(properties
		sel_20 {chair}
		sel_1 86
		sel_0 133
		sel_213 3
		sel_303 116
		sel_304 121
		sel_2 440
		sel_3 2
		sel_14 16384
		sel_15 0
	)

	(method (sel_307))

	(method (sel_300 param1)
		(switch param1
			(4
				(cond
					(local0
						(gCurRoom sel_146: sOffChair)
					)
					((and (>= (chair sel_1:) 104) (not local0))
						(gCurRoom sel_146: sOnChair)
					)
					((>= (chair sel_1:) 104)
						(gCurRoom sel_146: sOffChair)
					)
					(else
						(gCurRoom sel_146: sMoveChair)
					)
				)
			)
			(3
				(cond
					((and (>= (chair sel_1:) 104) (not local0))
						(gCurRoom sel_146: sOnChair)
					)
					((>= (chair sel_1:) 104)
						(gCurRoom sel_146: sOffChair)
					)
					(else
						(gCurRoom sel_146: sMoveChair)
					)
				)
			)
			(else
				(super sel_300: param1 &rest)
			)
		)
	)
)

(instance transomDoor of Door
	(properties
		sel_20 {transomDoor}
		sel_1 87
		sel_0 100
		sel_82 -26
		sel_213 5
		sel_303 117
		sel_304 122
		sel_2 448
		sel_60 8
		sel_14 4096
	)

	(method (sel_307))

	(method (sel_300 param1)
		(switch param1
			(4
				(if (not local0)
					(gMessager sel_295: 5 4)
					(noise sel_40: 48 sel_3: 1 sel_99: 5 sel_39:)
				else
					(gCurRoom sel_146: sOffChair)
				)
			)
			(else
				(super sel_300: param1 &rest)
			)
		)
	)

	(method (sel_606)
		(super sel_606: 94 119 108 120 88 131 80 125)
	)
)

(instance transomWin of Prop
	(properties
		sel_20 {transomWin}
		sel_1 88
		sel_0 65
		sel_213 4
		sel_2 448
		sel_3 1
	)

	(method (sel_307))

	(method (sel_300 param1)
		(switch param1
			(4
				(cond
					((not (>= (chair sel_1:) 104))
						(gMessager sel_295: 4 4 1)
					)
					((== (transomWin sel_4:) 0)
						(gCurRoom sel_146: sOpenTransom)
					)
					(else
						(gCurRoom sel_146: sCloseTransom)
					)
				)
			)
			(8
				(if (= local0 0)
					(gMessager sel_295: 4 8 0 0)
				else
					(gMessager sel_295: 4 8 2 0)
				)
			)
			(else
				(super sel_300: param1 &rest)
			)
		)
	)
)

(instance westNoDoor of Feature
	(properties
		sel_20 {westNoDoor}
		sel_1 92
		sel_0 101
		sel_213 15
		sel_6 79
		sel_7 88
		sel_8 123
		sel_9 96
		sel_301 40
	)

	(method (sel_300 param1)
		(switch param1
			(1
				(gMessager sel_295: 15 1 3 0)
			)
			(else
				(super sel_300: param1 &rest)
			)
		)
	)
)

(instance armor4 of Feature
	(properties
		sel_20 {armor4}
		sel_1 107
		sel_0 89
		sel_213 7
		sel_6 76
		sel_7 101
		sel_8 122
		sel_9 113
		sel_301 40
	)
)

(instance armor7 of Feature
	(properties
		sel_20 {armor7}
		sel_1 192
		sel_0 100
		sel_213 8
		sel_6 77
		sel_7 185
		sel_8 123
		sel_9 200
		sel_301 40
	)
)

(instance armor8 of Feature
	(properties
		sel_20 {armor8}
		sel_1 212
		sel_0 103
		sel_213 9
		sel_6 72
		sel_7 202
		sel_8 134
		sel_9 222
		sel_301 40
	)
)

(class ArmorFlag of Feature
	(properties
		sel_20 {ArmorFlag}
		sel_301 40
	)

	(method (sel_300 param1)
		(switch param1
			(8
				(gMessager sel_295: 1 8 0 0)
			)
			(else
				(super sel_300: param1 &rest)
			)
		)
	)
)

(instance flag4 of ArmorFlag
	(properties
		sel_20 {flag4}
		sel_1 111
		sel_0 51
		sel_213 10
		sel_6 43
		sel_7 104
		sel_8 60
		sel_9 119
	)
)

(instance flag5 of ArmorFlag
	(properties
		sel_20 {flag5}
		sel_1 116
		sel_0 67
		sel_213 11
		sel_6 61
		sel_7 110
		sel_8 74
		sel_9 122
	)
)

(instance flag6 of ArmorFlag
	(properties
		sel_20 {flag6}
		sel_1 172
		sel_0 66
		sel_213 12
		sel_6 59
		sel_7 168
		sel_8 74
		sel_9 177
	)
)

(instance flag7 of ArmorFlag
	(properties
		sel_20 {flag7}
		sel_1 174
		sel_0 50
		sel_213 13
		sel_6 43
		sel_7 167
		sel_8 58
		sel_9 181
	)
)

(instance rearDoorway of Feature
	(properties
		sel_20 {rearDoorway}
		sel_0 100
		sel_213 2
		sel_6 83
		sel_7 126
		sel_8 112
		sel_9 170
	)
)

(instance southExitFeature of ExitFeature
	(properties
		sel_20 {southExitFeature}
		sel_6 143
		sel_7 74
		sel_8 189
		sel_9 227
		sel_33 11
		sel_583 3
		sel_213 17
	)
)

(instance noise of Sound
	(properties
		sel_20 {noise}
		sel_99 1
	)
)
