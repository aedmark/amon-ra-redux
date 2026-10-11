;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 490)
(include sci.sh)
(use Main)
(use eRS)
(use ExitFeature)
(use Inset)
(use PChase)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use MoveFwd)
(use LoadMany)
(use StopWalk)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm490 0
)

(local
	local0
	local1
)

(instance rm490 of LBRoom
	(properties
		sel_20 {rm490}
		sel_213 5
		sel_408 490
		sel_410 440
		sel_411 440
		sel_412 440
		sel_107 150
		sel_108 100
	)

	(method (sel_110)
		(LoadMany rsVIEW 491 424 423 818 426 831)
		(LoadMany rsSOUND 490 1)
		(gEgo
			sel_110:
			sel_585: (if (== gAct 5) 426 else 831)
			sel_320: Scaler 160 40 190 100
		)
		(if (== gAct 5)
			(self sel_414: 94)
			(gCurRoom sel_259: (List sel_109:))
			((ScriptID 2490 0) sel_57: (gCurRoom sel_259:)) ; poly2490Code
		else
			(self sel_414: 90)
		)
		(switch gPrevRoomNum
			(sel_411
				(self sel_146: sEnterSouth)
			)
			(else
				(gEgo sel_153: 160 160)
				(gGame sel_588:)
			)
		)
		(super sel_110:)
		(if (or (IsFlag 143) (IsFlag 72))
			(if (IsFlag 37)
				(zHead
					sel_3: 2
					sel_4: 1
					sel_1: 231
					sel_0: 133
					sel_311: 4 1 8
					sel_110:
					sel_63: 10
					sel_303: 213
					sel_304: 135
				)
				(self
					sel_395:
						(= local0
							((Polygon sel_109:)
								sel_31: 2
								sel_110: 252 133 236 143 201 132 227 130
								sel_117:
							)
						)
				)
			else
				(zHead sel_311: 4 1 8 sel_110:)
			)
		)
		(southExitFeature sel_110:)
		(westExitFeature sel_110:)
		(eastExitFeature sel_110:)
		(genericHead sel_110:)
		(floor sel_110:)
		(if (== gAct 5)
			(oriley sel_110: sel_161: Walk sel_320: Scaler 160 40 190 80)
		)
	)

	(method (sel_57)
		(super sel_57:)
		(cond
			(sel_142)
			((StepOn gEgo 2)
				(gCurRoom sel_146: sExitSouth)
			)
		)
	)

	(method (sel_111)
		(DisposeScript 2490)
		(super sel_111:)
	)

	(method (sel_399)
		(if (IsObject local0)
			((gCurRoom sel_259:) sel_81: local0)
			(local0 sel_111:)
		)
		(super sel_399: &rest)
	)

	(method (sel_403)
		(if (== gAct 5)
			(if (gCurRoom sel_142:)
				((gCurRoom sel_142:) sel_65: sKillHer)
			else
				(gCurRoom sel_146: sKillHer)
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
				(gEgo sel_153: 320 190 sel_253: 315 sel_312: MoveFwd 40 self)
			)
			(1
				(gGame sel_588:)
				(self sel_111:)
			)
		)
	)
)

(instance sExitSouth of Script
	(properties
		sel_20 {sExitSouth}
	)

	(method (sel_144 param1)
		(switch (= sel_29 param1)
			(0
				(gGame sel_587:)
				(= sel_136 1)
			)
			(1
				(cond
					((> (gEgo sel_1:) 310)
						(gEgo sel_253: 90)
					)
					((< (gEgo sel_1:) 20)
						(gEgo sel_253: 270)
					)
					(else
						(gEgo sel_253: 180)
					)
				)
				(gEgo sel_312: MoveFwd 100 self)
			)
			(2
				(gCurRoom sel_399: 440)
			)
		)
	)
)

(instance sOhNoMurder of Script
	(properties
		sel_20 {sOhNoMurder}
	)

	(method (sel_144 param1)
		(switch (= sel_29 param1)
			(0
				(gGame sel_587:)
				(= sel_136 2)
			)
			(1
				(if (not (TimeCheck $b102)) ; has 11:15 pm occurred?
					((ScriptID 22 0) sel_57: -20222 self) ; triggerAndClock
				else
					(= sel_136 1)
				)
			)
			(2
				(WrapMusic sel_168: 1)
				(sWrapMusic sel_110: -1 1 6)
				(= sel_136 3)
			)
			(3
				(gCurRoom sel_422: inHead)
				(= sel_137 3)
			)
			(4
				(inHead sel_422: inReaction)
				(noise sel_40: 82 sel_99: 5 sel_3: 1 sel_39: self)
				(= local1 1)
			)
			(5
				(inReaction sel_111:)
				(gGame sel_588:)
				(self sel_111:)
			)
		)
	)
)

(instance sKillHer of Script
	(properties
		sel_20 {sKillHer}
	)

	(method (sel_144 param1)
		(switch (= sel_29 param1)
			(0
				(gGame sel_587:)
				(= sel_136 1)
			)
			(1
				(gEgo sel_312: PolyPath 186 150 self)
			)
			(2
				(gGameMusic1 sel_40: 3 sel_3: 1 sel_99: 1 sel_39:)
				(oriley sel_53: 4 sel_244: 4 sel_312: PChase gEgo 25 self)
			)
			(3
				(Face gEgo oriley)
				(oriley sel_2: 424 sel_4: 0 sel_161: End self)
			)
			(4
				(noise sel_40: 80 sel_99: 5 sel_3: 1 sel_39:)
				(gEgo sel_2: 858 sel_161: End self)
			)
			(5
				(= global145 0) ; "You came in thinking like a journalist, and you left with a skull full of mush."
				(gCurRoom sel_399: 99)
				(self sel_111:)
			)
		)
	)
)

(instance sGetHead of Script
	(properties
		sel_20 {sGetHead}
	)

	(method (sel_144 param1)
		(switch (= sel_29 param1)
			(0
				(gGame sel_587:)
				(= sel_136 1)
			)
			(1
				(gCurRoom
					sel_395:
						(= local0
							((Polygon sel_109:)
								sel_31: 2
								sel_110: 252 133 236 143 201 132 227 130
								sel_117:
							)
						)
				)
				(zHead sel_3: 1 sel_161: End self)
			)
			(2
				(zHead sel_155: 2 sel_4: 2 sel_153: 211 131 sel_161: End self)
				(noise sel_40: 490 sel_99: 5 sel_39:)
			)
			(3
				(zHead sel_161: End self sel_312: MoveTo 231 133)
			)
			(4
				(zHead sel_161: CT 1 1 self)
			)
			(5
				(SetFlag 37)
				(zHead sel_303: 213 sel_304: 135 sel_161: 0 sel_63: 10)
				(gGame sel_588:)
				(self sel_111:)
			)
		)
	)
)

(instance sTheyComeIn of Script
	(properties
		sel_20 {sTheyComeIn}
	)

	(method (sel_144 param1)
		(switch (= sel_29 param1)
			(0
				(gGame sel_587:)
				(sWrapMusic sel_111: 1)
				(= sel_136 1)
			)
			(1
				(localSound sel_111:)
				((ScriptID 32 0) ; aHeimlich
					sel_620: 490
					sel_110:
					sel_2: 814
					sel_1: 253
					sel_0: 240
					sel_161: Walk
					sel_312: MoveTo 249 145 self
				)
				(= sel_141 ((ScriptID 90 3) sel_620:)) ; aORiley
				((ScriptID 90 3) ; aORiley
					sel_182: 490
					sel_2: 818
					sel_1: 280
					sel_0: 240
					sel_312: MoveTo 290 141 self
				)
				(gGameMusic2 sel_40: 350 sel_99: 1 sel_3: -1 sel_39:)
			)
			(2 0)
			(3
				((ScriptID 32 0) sel_161: StopWalk -1) ; aHeimlich
				((ScriptID 90 3) sel_3: 7) ; aORiley
				(= sel_136 1)
			)
			(4
				(Face gEgo (ScriptID 90 3)) ; aORiley
				(= sel_136 5)
			)
			(5
				(gMessager sel_295: 1 0 1 0 self 1490)
			)
			(6
				((ScriptID 32 0) sel_161: Walk sel_312: PolyPath 275 300 self) ; aHeimlich
				((ScriptID 90 3) sel_312: PolyPath 302 300 self) ; aORiley
			)
			(7
				0
				(gGameMusic2 sel_170:)
				(WrapMusic sel_168: 0)
				((ScriptID 90 3) sel_182: sel_141) ; aORiley
				(gGame sel_588:)
				(gGame sel_87: 1 144)
				(SetFlag 36)
				(self sel_111:)
			)
		)
	)
)

(instance sExamineHead of Script
	(properties
		sel_20 {sExamineHead}
	)

	(method (sel_144 param1)
		(switch (= sel_29 param1)
			(0
				(WrapMusic sel_168: 1)
				(if (not (== gAct 5))
					(mExamineMusic sel_39:)
				)
				(gCurRoom sel_422: inHead self)
			)
			(1
				(mExamineMusic sel_111:)
				(WrapMusic sel_168: 0)
				(self sel_111:)
			)
		)
	)
)

(instance oriley of Actor
	(properties
		sel_20 {oriley}
		sel_1 150
		sel_0 300
		sel_2 423
	)
)

(instance zHead of Actor
	(properties
		sel_20 {zHead}
		sel_1 190
		sel_0 87
		sel_213 1
		sel_303 189
		sel_304 135
		sel_2 491
		sel_3 1
		sel_14 16385
	)

	(method (sel_300 param1)
		(if (== gAct 5)
			(gMessager sel_295: 36 0 0 0)
		else
			(switch param1
				(1
					(if (IsFlag 36)
						(gCurRoom sel_146: sExamineHead)
					else
						(gCurRoom sel_146: sOhNoMurder)
					)
				)
				(8
					(self sel_300: 1)
				)
				(4
					(cond
						((IsFlag 37)
							(gMessager sel_295: 1 4 1)
						)
						((not (IsFlag 36))
							(gMessager sel_295: 1 4 2)
						)
						(else
							(gCurRoom sel_146: sGetHead)
						)
					)
				)
				(else
					(super sel_300: param1 &rest)
				)
			)
		)
	)
)

(instance floor of Feature
	(properties
		sel_20 {floor}
		sel_302 16386
	)
)

(instance inHead of Inset
	(properties
		sel_20 {inHead}
		sel_408 495
		sel_560 1
		sel_570 1
		sel_213 6
	)

	(method (sel_110)
		(gEgo sel_102:)
		(zHead sel_102:)
		(super sel_110: &rest)
		(gGame sel_87: 1 144)
		(proc0_8 1)
	)

	(method (sel_111)
		(gEgo sel_216:)
		(zHead sel_216:)
		(proc0_8 0)
		(if (not (IsFlag 36))
			(gCurRoom sel_146: sTheyComeIn)
		)
		(super sel_111:)
	)

	(method (sel_300 param1)
		(switch param1
			(13
				(proc0_8 0)
				(inHead sel_111:)
			)
			(else
				(super sel_300: param1 &rest)
			)
		)
	)
)

(instance inReaction of Inset
	(properties
		sel_20 {inReaction}
		sel_408 555
		sel_560 1
		sel_570 1
	)
)

(instance southExitFeature of ExitFeature
	(properties
		sel_20 {southExitFeature}
		sel_6 184
		sel_8 189
		sel_9 319
		sel_33 11
		sel_583 3
		sel_213 35
	)
)

(instance eastExitFeature of ExitFeature
	(properties
		sel_20 {eastExitFeature}
		sel_6 133
		sel_7 314
		sel_8 189
		sel_9 319
		sel_33 14
		sel_583 2
		sel_213 35
	)
)

(instance westExitFeature of ExitFeature
	(properties
		sel_20 {westExitFeature}
		sel_6 147
		sel_8 189
		sel_9 5
		sel_33 12
		sel_583 3
		sel_213 35
	)
)

(instance genericHead of Feature
	(properties
		sel_20 {genericHead}
		sel_0 5
		sel_301 40
	)

	(method (sel_300 param1)
		(switch param1
			(4
				(gMessager sel_295: 13 4)
			)
			(8
				(gMessager sel_295: 13 8)
			)
			(else
				(super sel_300: param1 &rest)
			)
		)
	)

	(method (sel_218 param1)
		(if (super sel_218: param1)
			(cond
				(
					(and
						(<= 59 gMouseX)
						(<= gMouseX 74)
						(<= 68 gMouseY)
						(<= gMouseY 82)
					)
					(= sel_213 2)
				)
				(
					(and
						(<= 39 gMouseX)
						(<= gMouseX 56)
						(<= 47 gMouseY)
						(<= gMouseY 65)
					)
					(= sel_213 9)
				)
				(
					(and
						(<= 136 gMouseX)
						(<= gMouseX 147)
						(<= 87 gMouseY)
						(<= gMouseY 99)
					)
					(= sel_213 19)
				)
				(
					(and
						(<= 152 gMouseX)
						(<= gMouseX 163)
						(<= 91 gMouseY)
						(<= gMouseY 101)
					)
					(= sel_213 20)
				)
				(
					(and
						(<= 63 gMouseX)
						(<= gMouseX 80)
						(<= 108 gMouseY)
						(<= gMouseY 125)
					)
					(= sel_213 14)
				)
				(
					(and
						(<= 276 gMouseX)
						(<= gMouseX 294)
						(<= 74 gMouseY)
						(<= gMouseY 91)
					)
					(= sel_213 31)
				)
				(
					(and
						(<= 182 gMouseX)
						(<= gMouseX 195)
						(<= 112 gMouseY)
						(<= gMouseY 124)
					)
					(= sel_213 27)
				)
				(
					(and
						(<= 146 gMouseX)
						(<= gMouseX 152)
						(<= 101 gMouseY)
						(<= gMouseY 113)
					)
					(= sel_213 3)
				)
				(
					(and
						(<= 88 gMouseX)
						(<= gMouseX 102)
						(<= 107 gMouseY)
						(<= gMouseY 122)
					)
					(= sel_213 15)
				)
				(
					(and
						(<= 133 gMouseX)
						(<= gMouseX 146)
						(<= 68 gMouseY)
						(<= gMouseY 84)
					)
					(= sel_213 4)
				)
				(
					(and
						(<= 74 gMouseX)
						(<= gMouseX 91)
						(<= 61 gMouseY)
						(<= gMouseY 76)
					)
					(= sel_213 16)
				)
				(
					(and
						(<= 139 gMouseX)
						(<= gMouseX 150)
						(<= 113 gMouseY)
						(<= gMouseY 125)
					)
					(= sel_213 10)
				)
				(
					(and
						(<= 177 gMouseX)
						(<= gMouseX 184)
						(<= 85 gMouseY)
						(<= gMouseY 96)
					)
					(= sel_213 26)
				)
				(
					(and
						(<= 243 gMouseX)
						(<= gMouseX 262)
						(<= 75 gMouseY)
						(<= gMouseY 93)
					)
					(= sel_213 30)
				)
				(
					(and
						(<= 89 gMouseX)
						(<= gMouseX 101)
						(<= 53 gMouseY)
						(<= gMouseY 66)
					)
					(= sel_213 17)
				)
				(
					(and
						(<= 165 gMouseX)
						(<= gMouseX 176)
						(<= 93 gMouseY)
						(<= gMouseY 103)
					)
					(= sel_213 23)
				)
				(
					(and
						(<= 185 gMouseX)
						(<= gMouseX 195)
						(<= 89 gMouseY)
						(<= gMouseY 99)
					)
					(= sel_213 25)
				)
				(
					(and
						(<= 279 gMouseX)
						(<= gMouseX 294)
						(<= 102 gMouseY)
						(<= gMouseY 119)
					)
					(= sel_213 24)
				)
				(
					(and
						(<= 153 gMouseX)
						(<= gMouseX 163)
						(<= 104 gMouseY)
						(<= gMouseY 114)
					)
					(= sel_213 18)
				)
				(
					(and
						(<= 312 gMouseX)
						(<= gMouseX 319)
						(<= 73 gMouseY)
						(<= gMouseY 88)
					)
					(= sel_213 29)
				)
				(
					(and
						(<= 68 gMouseX)
						(<= gMouseX 88)
						(<= 88 gMouseY)
						(<= gMouseY 104)
					)
					(= sel_213 12)
				)
				(
					(and
						(<= 245 gMouseX)
						(<= gMouseX 261)
						(<= 101 gMouseY)
						(<= gMouseY 117)
					)
					(= sel_213 28)
				)
				(
					(and
						(<= 148 gMouseX)
						(<= gMouseX 156)
						(<= 78 gMouseY)
						(<= gMouseY 89)
					)
					(= sel_213 21)
				)
				(
					(and
						(<= 159 gMouseX)
						(<= gMouseX 169)
						(<= 81 gMouseY)
						(<= gMouseY 93)
					)
					(= sel_213 22)
				)
				(
					(and
						(<= 134 gMouseX)
						(<= gMouseX 145)
						(<= 99 gMouseY)
						(<= gMouseY 112)
					)
					(= sel_213 11)
				)
				(
					(and
						(<= 313 gMouseX)
						(<= gMouseX 319)
						(<= 103 gMouseY)
						(<= gMouseY 118)
					)
					(= sel_213 33)
				)
				(
					(and
						(<= 178 gMouseX)
						(<= gMouseX 188)
						(<= 97 gMouseY)
						(<= gMouseY 109)
					)
					(= sel_213 32)
				)
			)
		)
	)
)

(instance noise of Sound
	(properties
		sel_20 {noise}
		sel_99 1
	)
)

(instance mExamineMusic of Sound
	(properties
		sel_20 {mExamineMusic}
		sel_99 1
		sel_40 6
		sel_3 -1
	)
)

(instance sWrapMusic of WrapMusic
	(properties
		sel_20 {sWrapMusic}
	)

	(method (sel_110)
		(= sel_608 localSound)
		(super sel_110: &rest)
	)
)

(instance localSound of Sound
	(properties
		sel_20 {localSound}
	)
)
