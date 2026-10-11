;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 480)
(include sci.sh)
(use Main)
(use eRS)
(use Inset)
(use Talker)
(use Scaler)
(use RandCycle)
(use PolyPath)
(use Feature)
(use LoadMany)
(use Rev)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm480 0
	Rex 39
)

(local
	local0
	local1
	local2
)

(instance rm480 of LBRoom
	(properties
		sel_20 {rm480}
		sel_213 1
		sel_408 480
		sel_409 430
	)

	(method (sel_110)
		(LoadMany rsVIEW 423 424 741 426 482 442 483 481 480 831)
		(LoadMany rsSOUND 52 483 480 481 482)
		(gEgo
			sel_110:
			sel_585: (if (== gAct 5) 426 else 831)
			sel_320: Scaler 110 0 190 0
		)
		(if (== gAct 5)
			(self sel_414: 94)
			(gCurRoom sel_259: (List sel_109:))
			((ScriptID 2480 0) sel_57: (gCurRoom sel_259:)) ; poly2480Code
		else
			(self sel_414: 90)
		)
		(switch gPrevRoomNum
			(sel_409
				(gEgo sel_1: 138 sel_0: 121)
				(gCurRoom sel_146: sEnterNorth)
			)
			(740
				(gCurRoom sel_146: sChaseSequence)
				(lump sel_110:)
				(rexMouth sel_311: 4 1 sel_110:)
				(gEgo sel_102:)
				(steve sel_110: sel_102:)
			)
			(else
				(gEgo sel_153: 160 160)
				(gGame sel_588:)
			)
		)
		(super sel_110:)
		(signButton sel_311: 1 4 sel_110:)
		(painting sel_110:)
		(dino sel_110:)
		(rexMouth sel_311: 4 1)
		(rex sel_311: 4 1 sel_110:)
		(if (not (gEgo sel_238: 18))
			(bone sel_110: sel_313:)
		)
		(dinoBones sel_311: 4 1 sel_110:)
		(gNarrator sel_1: 10 sel_0: 10)
	)

	(method (sel_57)
		(super sel_57:)
		(cond
			((and (== (gCurRoom sel_142:) sChaseSequence) (StepOn gEgo 2))
				((self sel_142:) sel_145:)
			)
			(sel_142)
			((StepOn gEgo 2)
				(self sel_146: sExitNorth)
			)
			((StepOn gEgo 4)
				(self sel_146: sAroundTRexCCW)
			)
			((StepOn gEgo 32)
				(self sel_146: sAroundTRexCW)
			)
			((StepOn gEgo 16)
				(self sel_146: sAroundDinoCCW)
			)
			((StepOn gEgo 8)
				(self sel_146: sAroundDinoCW)
			)
		)
	)

	(method (sel_111)
		(if local1
			(sWrapMusic sel_111: 1)
		)
		(DisposeScript 2480)
		(super sel_111:)
	)

	(method (sel_133 param1)
		(if
			(and
				(gNarrator sel_203:)
				(or
					(and
						(== (param1 sel_31:) 4)
						(OneOf (param1 sel_37:) 27 13)
					)
					(and (== (param1 sel_31:) 1) (not (param1 sel_61:)))
				)
			)
			(param1 sel_73: 1)
			(if gModelessDialog
				(gModelessDialog sel_111:)
			)
		else
			(super sel_133: param1)
		)
	)

	(method (sel_403)
		(if (== gAct 5)
			(if (gCurRoom sel_142:)
				((gCurRoom sel_142:) sel_65: sCaughtYou)
			else
				(gCurRoom sel_146: sCaughtYou)
			)
		)
	)
)

(instance sCaughtYou of Script
	(properties
		sel_20 {sCaughtYou}
	)

	(method (sel_144 param1)
		(switch (= sel_29 param1)
			(0
				(oriley
					sel_110:
					sel_2: 423
					sel_153: 137 122
					sel_63: -1
					sel_161: Walk
					sel_320: Scaler 110 0 160 0
				)
				(= sel_136 1)
			)
			(1
				(gGame sel_587:)
				(= sel_136 1)
			)
			(2
				(gEgo sel_312: PolyPath 219 179 self)
			)
			(3
				(gGameMusic1 sel_40: 3 sel_3: 1 sel_99: 1 sel_39:)
				(oriley sel_312: MoveTo 169 124 self)
			)
			(4
				(oriley sel_312: PolyPath 196 173 self)
			)
			(5
				(Face gEgo oriley)
				(= sel_136 3)
			)
			(6
				(oriley sel_2: 424 sel_4: 0 sel_161: End self)
			)
			(7
				(noise sel_40: 80 sel_99: 5 sel_3: 1 sel_39:)
				(gEgo sel_2: 858 sel_161: End self)
			)
			(8
				(= global145 0) ; "You came in thinking like a journalist, and you left with a skull full of mush."
				(gCurRoom sel_399: 99)
			)
		)
	)
)

(instance sChaseSequence of Script
	(properties
		sel_20 {sChaseSequence}
	)

	(method (sel_57)
		(if (and (== (self sel_29:) 12) local0)
			(gGame sel_587:)
			(self sel_145:)
		)
		(super sel_57:)
	)

	(method (sel_144 param1)
		(switch (= sel_29 param1)
			(0
				(LoadMany rsVIEW 482)
				(Load rsSOUND 480)
				(gGameMusic2 sel_167:)
				(gGameMusic1 sel_40: 482 sel_3: -1 sel_99: 1 sel_39:)
				(gGame sel_587:)
				(= sel_136 1)
			)
			(1
				(rexMouth sel_161: End self)
				(noise sel_40: 480 sel_99: 5 sel_39:)
			)
			(2
				(if (IsFlag 46)
					(self sel_146: sRatsFall self)
				else
					(= sel_136 1)
				)
			)
			(3
				(lump sel_4: 0 sel_161: End self)
			)
			(4
				(gEgo
					sel_216:
					sel_2: 482
					sel_155: 3
					sel_52: 8
					sel_4: 0
					sel_153: 184 141
					sel_63: 12
					sel_161: Fwd
					sel_312: MoveTo 179 160 self
				)
			)
			(5
				(gEgo sel_155: 0 sel_161: End self)
				(= local2 (gEgo sel_53:))
			)
			(6
				(gEgo
					sel_2: 831
					sel_155: 6
					sel_52: 2
					sel_153: 171 158
					sel_161: Rev
					sel_352: 10
					sel_312: MoveTo 165 162 self
				)
			)
			(7
				(lump sel_4: 0 sel_161: End self)
			)
			(8
				(steve sel_216: sel_156: 0 sel_52: 8 sel_155: 1)
				(= sel_136 1)
			)
			(9
				(steve sel_312: MoveTo 179 160 self)
			)
			(10
				(gEgo sel_585: 426 sel_352: local2)
				(signButton sel_303: 296 sel_304: 189 sel_311: 4 1)
				(steve sel_153: 179 160 sel_161: End self)
			)
			(11
				(steve sel_155: 1 sel_312: MoveTo 160 158 self)
			)
			(12
				(gGame sel_588:)
				(= sel_137 20)
			)
			(13
				(gGame sel_587:)
				(oriley sel_110: sel_320: Scaler 110 0 190 0 sel_102:)
				(if local0
					(self sel_146: sOrileyCaught)
				else
					(self sel_146: sKillThem)
				)
			)
		)
	)
)

(instance sOrileyCaught of Script
	(properties
		sel_20 {sOrileyCaught}
	)

	(method (sel_57)
		(if
			(and
				(== (localSound sel_40:) 483)
				(== (localSound sel_165:) -1)
				(== (self sel_29:) 15)
			)
			(self sel_145:)
		)
		(super sel_57:)
	)

	(method (sel_144 param1)
		(switch (= sel_29 param1)
			(0
				(gGame sel_87: 1 138)
				(rexMouth sel_161: End self)
			)
			(1
				(lump sel_4: 0 sel_161: End self)
			)
			(2
				(rexMouth sel_161: End self)
				(noise sel_40: 480 sel_99: 5 sel_39:)
			)
			(3
				(oriley sel_216:)
				(= sel_136 1)
			)
			(4
				(gGameMusic1 sel_167:)
				(oriley sel_155: 0 sel_312: MoveTo 181 121 self)
				(rexMouth sel_161: End self)
			)
			(5
				(= local1 1)
				(WrapMusic sel_168: 1)
				(sWrapMusic sel_110: 0 1481 483)
				0
			)
			(6
				(rexMouth sel_161: Beg self)
				(oriley sel_161: End)
			)
			(7
				(oriley sel_161: CT 3 -1 self)
			)
			(8
				(oriley sel_161: End self)
			)
			(9
				(= sel_137 2)
				(steve sel_316: 1)
			)
			(10
				(gEgo sel_312: PolyPath 169 141 self)
			)
			(11
				(= sel_137 1)
			)
			(12
				(gEgo sel_2: 483 sel_3: 13 sel_4: 0 sel_161: End self)
			)
			(13
				(= sel_137 3)
			)
			(14
				((ScriptID 22 0) sel_57: 2) ; triggerAndClock
				(gGame sel_87: 1 151)
				(gCast sel_119: 102)
				(gCurRoom sel_417: 485)
				(= sel_137 5)
			)
			(15 0)
			(16
				(WrapMusic sel_168: 0)
				(gCurRoom sel_399: 26)
			)
		)
	)
)

(instance sKillThem of Script
	(properties
		sel_20 {sKillThem}
	)

	(method (sel_144 param1)
		(switch (= sel_29 param1)
			(0
				(gGame sel_587:)
				(gGameMusic1 sel_40: 3 sel_3: 1 sel_99: 1 sel_39:)
				(= sel_136 1)
			)
			(1
				(lump sel_4: 0 sel_161: End self)
			)
			(2
				(oriley sel_155: 1 sel_153: 186 141 sel_216:)
				(= sel_136 1)
			)
			(3
				(oriley sel_161: End self)
			)
			(4
				(noise sel_40: 52 sel_99: 5 sel_3: 1 sel_39:)
				(oriley sel_155: 5 sel_153: 177 143 sel_161: End self)
			)
			(5
				(steve
					sel_2: 483
					sel_3: 10
					sel_4: 0
					sel_153: 125 169
					sel_244: 12
					sel_161: End self
				)
			)
			(6
				(gGameMusic1 sel_170:)
				(cond
					((<= (gEgo sel_1:) 131)
						(oriley sel_155: 5)
					)
					((and (<= (gEgo sel_1:) 172) (>= (gEgo sel_0:) 161))
						(oriley sel_155: 5)
					)
					((and (> (gEgo sel_1:) 172) (>= (gEgo sel_0:) 159))
						(oriley sel_155: 6)
					)
					((> (gEgo sel_1:) 320)
						(oriley sel_155: 6)
					)
					((and (>= (gEgo sel_1:) 180) (<= (gEgo sel_0:) 141))
						(oriley sel_155: 7)
					)
					(else
						(oriley sel_155: 8)
					)
				)
				(oriley sel_161: End self)
				(noise sel_40: 52 sel_99: 5 sel_3: 1 sel_39:)
			)
			(7
				(= global145 10) ; "You'll get nowhere with that holier-than-thou attitude."
				(gCurRoom sel_399: 99)
			)
		)
	)
)

(instance sGetDinoBoneFromInset of Script
	(properties
		sel_20 {sGetDinoBoneFromInset}
	)

	(method (sel_144 param1)
		(switch (= sel_29 param1)
			(0
				(inBone sel_111:)
				(bone sel_111:)
				(= sel_136 1)
			)
			(1
				(gGame sel_87: 1 139)
				(gEgo sel_350: 18)
				((ScriptID 21 0) sel_57: 787) ; addCluesCode
				(self sel_111:)
			)
		)
	)
)

(instance sGetDinoBone of Script
	(properties
		sel_20 {sGetDinoBone}
	)

	(method (sel_144 param1)
		(switch (= sel_29 param1)
			(0
				(gGame sel_587:)
				(= sel_136 1)
			)
			(1
				(gEgo sel_2: 481 sel_155: 0 sel_4: 0 sel_161: CT 2 1 self)
				(bone sel_111:)
			)
			(2
				(gEgo sel_161: End self)
			)
			(3
				(gEgo sel_2: 831 sel_3: 7)
				(= sel_136 1)
			)
			(4
				(gGame sel_588:)
				(gEgo
					sel_585: (if (== gAct 5) 426 else 831)
					sel_350: 18
				)
				((ScriptID 21 0) sel_57: 787) ; addCluesCode
				(gGame sel_87: 1 139)
				(self sel_111:)
			)
		)
	)
)

(instance sRexTalks of Script
	(properties
		sel_20 {sRexTalks}
	)

	(method (sel_144 param1)
		(switch (= sel_29 param1)
			(0
				(gUser sel_237: 0)
				(gGame sel_197: gWaitCursor)
				(gEgo sel_253: 0)
				(rexMouth sel_110:)
				(= sel_137 2)
			)
			(1
				(gGame sel_87: 1 138)
				(rexMouth sel_161: RandCycle)
				(gNarrator sel_203: 1)
				(gMessager sel_295: 5 4 2 0 self)
				(noise sel_40: 480 sel_99: 5 sel_39:)
				(gEgo sel_312: PolyPath 255 184 self)
			)
			(2 0)
			(3
				(gNarrator sel_203: 0 sel_111: 1)
				(rexMouth sel_313: sel_161: 0 sel_4: 0)
				(= sel_136 5)
			)
			(4
				(gGame sel_588:)
				(self sel_111:)
			)
		)
	)
)

(instance sRatsFall of Script
	(properties
		sel_20 {sRatsFall}
	)

	(method (sel_144 param1)
		(switch (= sel_29 param1)
			(0
				(rat1 sel_110:)
				(= sel_136 1)
			)
			(1
				(rat2 sel_110:)
				(rat1 sel_155: 1 sel_52: 7 sel_312: MoveTo 185 157 self)
			)
			(2
				(rat2 sel_155: 1 sel_52: 7 sel_312: MoveTo 186 152 self)
				(rat1
					sel_155: 8
					sel_4: 1
					sel_153: 175 155
					sel_312: MoveTo 219 200 self
				)
			)
			(3 0)
			(4
				(rat1 sel_155: 1 sel_153: 204 93 sel_312: MoveTo 185 157 self)
				(rat2
					sel_155: 8
					sel_4: 1
					sel_153: 171 160
					sel_312: MoveTo 228 200 self
				)
			)
			(5 0)
			(6
				(rat1
					sel_155: 8
					sel_4: 1
					sel_153: 175 155
					sel_312: MoveTo 219 200 self
				)
			)
			(7
				(= sel_137 1)
			)
			(8
				(rat1 sel_111:)
				(rat2 sel_111:)
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
				(gEgo sel_312: PolyPath 174 125 self)
			)
			(2
				(gGame sel_588:)
				(self sel_111:)
			)
		)
	)
)

(instance sExitNorth of Script
	(properties
		sel_20 {sExitNorth}
	)

	(method (sel_144 param1)
		(switch (= sel_29 param1)
			(0
				(gGame sel_587:)
				(= sel_136 1)
			)
			(1
				(gEgo sel_312: PolyPath 138 121 self)
			)
			(2
				(if
					(and
						(== gAct 3)
						(TimeCheck $b102 1) ; can 11:15 pm occur?
						(not (IsFlag 72))
					)
					(gCurRoom sel_399: 435)
				else
					(gCurRoom sel_399: (gCurRoom sel_409:))
				)
			)
		)
	)
)

(instance sAroundTRexCCW of Script
	(properties
		sel_20 {sAroundTRexCCW}
	)

	(method (sel_144 param1)
		(switch (= sel_29 param1)
			(0
				(gGame sel_587:)
				(= sel_136 3)
			)
			(1
				(gEgo sel_312: PolyPath 320 110 self)
			)
			(2
				(gEgo sel_312: PolyPath 220 119 self)
			)
			(3
				(gGame sel_588:)
				(self sel_111:)
			)
		)
	)
)

(instance sAroundTRexCW of Script
	(properties
		sel_20 {sAroundTRexCW}
	)

	(method (sel_144 param1)
		(switch (= sel_29 param1)
			(0
				(gGame sel_587:)
				(= sel_136 3)
			)
			(1
				(gEgo sel_312: PolyPath 320 110 self)
			)
			(2
				(gEgo sel_312: PolyPath 234 181 self)
			)
			(3
				(gGame sel_588:)
				(self sel_111:)
			)
		)
	)
)

(instance sAroundDinoCCW of Script
	(properties
		sel_20 {sAroundDinoCCW}
	)

	(method (sel_144 param1)
		(switch (= sel_29 param1)
			(0
				(gGame sel_587:)
				(= sel_136 3)
			)
			(1
				(gEgo sel_63: 15 sel_312: PolyPath 145 250 self)
			)
			(2
				(gEgo sel_312: PolyPath 234 181 self)
			)
			(3
				(gEgo sel_63: -1)
				(gGame sel_588:)
				(self sel_111:)
			)
		)
	)
)

(instance sAroundDinoCW of Script
	(properties
		sel_20 {sAroundDinoCW}
	)

	(method (sel_144 param1)
		(switch (= sel_29 param1)
			(0
				(gGame sel_587:)
				(= sel_136 3)
			)
			(1
				(gEgo sel_312: PolyPath 225 250 self)
			)
			(2
				(gEgo sel_63: 15 sel_312: PolyPath 9 176 self)
			)
			(3
				(gEgo sel_63: -1)
				(gGame sel_588:)
				(self sel_111:)
			)
		)
	)
)

(instance sLookBones of Script
	(properties
		sel_20 {sLookBones}
	)

	(method (sel_144 param1)
		(switch (= sel_29 param1)
			(0
				(gMessager sel_295: 7 1 0 0 self)
			)
			(1
				(gCurRoom sel_422: inBone)
				(self sel_111:)
			)
		)
	)
)

(instance rexMouth of Prop
	(properties
		sel_20 {rexMouth}
		sel_1 230
		sel_0 59
		sel_213 3
		sel_303 160
		sel_304 160
		sel_2 482
		sel_3 2
		sel_60 12
		sel_14 17
	)
)

(instance bone of View
	(properties
		sel_20 {bone}
		sel_1 32
		sel_0 128
		sel_2 481
		sel_3 1
		sel_14 16384
	)

	(method (sel_300 param1)
		(dinoBones sel_300: &rest)
	)
)

(instance dinoBones of Feature
	(properties
		sel_20 {dinoBones}
		sel_1 1
		sel_0 140
		sel_213 7
		sel_6 128
		sel_7 20
		sel_8 145
		sel_9 65
		sel_301 40
		sel_303 56
		sel_304 152
	)

	(method (sel_300 param1)
		(switch param1
			(1
				(cond
					((gEgo sel_238: 18)
						(gMessager sel_295: 7 1 1)
					)
					((== (gCurRoom sel_142:) sChaseSequence)
						(gMessager sel_295: 9 1 5)
					)
					(else
						(gCurRoom sel_146: sLookBones)
					)
				)
			)
			(4
				(cond
					((gEgo sel_238: 18)
						(gMessager sel_295: 7 4 1)
					)
					((== (gCurRoom sel_142:) sChaseSequence)
						(gMessager sel_295: 9 4 5)
					)
					(else
						(gCurRoom sel_146: sGetDinoBone)
					)
				)
			)
			(else
				(super sel_300: param1 &rest)
			)
		)
	)
)

(instance inBone of Inset
	(properties
		sel_20 {inBone}
		sel_2 480
		sel_1 2
		sel_0 121
		sel_570 1
		sel_214 15
		sel_213 10
	)

	(method (sel_300 param1)
		(switch param1
			(4
				(gCurRoom sel_146: sGetDinoBoneFromInset)
			)
			(else
				(super sel_300: param1 &rest)
			)
		)
	)
)

(instance oriley of Actor
	(properties
		sel_20 {oriley}
		sel_1 191
		sel_0 113
		sel_2 483
		sel_4 3
		sel_60 12
		sel_14 16
	)
)

(instance steve of Actor
	(properties
		sel_20 {steve}
		sel_1 185
		sel_0 142
		sel_213 8
		sel_2 482
		sel_3 1
		sel_60 12
		sel_14 16
	)
)

(instance lump of Prop
	(properties
		sel_20 {lump}
		sel_1 258
		sel_0 75
		sel_213 2
		sel_2 480
		sel_3 1
		sel_60 12
		sel_14 16
	)
)

(instance rat1 of Actor
	(properties
		sel_20 {rat1}
		sel_1 204
		sel_0 93
		sel_52 4
		sel_2 741
		sel_3 1
		sel_60 12
		sel_14 16400
		sel_51 4
	)
)

(instance rat2 of Actor
	(properties
		sel_20 {rat2}
		sel_1 200
		sel_0 90
		sel_52 4
		sel_2 741
		sel_3 1
		sel_60 12
		sel_14 16400
		sel_51 4
	)
)

(instance signButton of Feature
	(properties
		sel_20 {signButton}
		sel_1 296
		sel_0 148
		sel_213 5
		sel_6 143
		sel_7 290
		sel_8 154
		sel_9 303
		sel_301 40
		sel_303 258
		sel_304 181
	)

	(method (sel_300 param1)
		(switch param1
			(4
				(if (== (gCurRoom sel_142:) sChaseSequence)
					(= local0 1)
				else
					(gCurRoom sel_146: sRexTalks)
				)
			)
			(else
				(super sel_300: param1 &rest)
			)
		)
	)
)

(instance painting of Feature
	(properties
		sel_20 {painting}
		sel_1 71
		sel_0 90
		sel_213 4
		sel_6 53
		sel_7 18
		sel_8 128
		sel_9 124
		sel_301 40
	)
)

(instance dino of Feature
	(properties
		sel_20 {dino}
		sel_0 100
		sel_213 6
		sel_302 8192
	)
)

(instance rex of Feature
	(properties
		sel_20 {rex}
		sel_1 277
		sel_0 149
		sel_213 2
		sel_302 16416
		sel_303 160
		sel_304 160
	)
)

(instance Rex of Narrator
	(properties
		sel_20 {Rex}
		sel_1 10
		sel_0 10
		sel_537 150
		sel_203 1
		sel_26 15
	)

	(method (sel_110)
		(= sel_30 gUserFont)
		(super sel_110: &rest)
	)
)

(instance noise of Sound
	(properties
		sel_20 {noise}
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
