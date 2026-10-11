;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 440)
(include sci.sh)
(use Main)
(use Door)
(use eRS)
(use ExitFeature)
(use MuseumRgn)
(use PursuitRgn)
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
	rm440 0
	sOutTapestry 1
	rm440Door 2
	noise 3
	bolt 4
)

(instance rm440 of LBRoom
	(properties
		sel_20 {rm440}
		sel_213 8
		sel_408 440
		sel_340 135
		sel_409 448
		sel_410 430
		sel_411 490
		sel_108 90
	)

	(method (sel_110)
		(LoadMany rsVIEW 432 424 423 858 831 426 442 440 443)
		(LoadMany rsSOUND 442 440)
		(gEgo
			sel_110:
			sel_585: (if (== gAct 5) 426 else 831)
			sel_320: Scaler 155 0 190 90
		)
		(if (== gAct 5)
			(self sel_414: 94)
			(gCurRoom sel_259: (List sel_109:))
			((ScriptID 2440 0) sel_57: (gCurRoom sel_259:)) ; poly2440Code
			(if (not (IsFlag 45))
				((ScriptID 94 1) sel_137: 1) ; pursuitTimer
			)
		else
			(self sel_414: 90)
		)
		(switch gPrevRoomNum
			(sel_409
				(gEgo sel_1: 171 sel_0: 148)
				(if (IsFlag 47)
					(gCurRoom sel_146: (ScriptID 444 0)) ; sHeKills
				)
				(gGame sel_588:)
			)
			(sel_411
				(gEgo sel_1: 160 sel_0: 210 sel_3: 3)
				(self sel_146: sEnterSouth)
			)
			(sel_410
				(gEgo sel_1: 197 sel_0: 143)
				(self sel_146: sEnterEast)
			)
			(else
				(gEgo sel_153: 160 160)
				(gGame sel_588:)
			)
		)
		(super sel_110:)
		(if (and (== gAct 4) (TimeCheck $4108 1)) ; can 4:15 am occur?
			((ScriptID 443 1) sel_317:) ; blood
			(if (not (gEgo sel_238: 12))
				((ScriptID 443 0) sel_110: sel_311: 4 1 8) ; boot
			)
		)
		(if (and (> gAct 2) (not (== gAct 5)))
			((ScriptID 443 4) sel_110: sel_311: 4 1 8) ; armorPippin
		else
			(armorPippin
				sel_110:
				sel_311:
					(if (== gAct 5)
						0
					else
						4
						1
						8
					)
			)
		)
		(rm440Door sel_110: sel_594: otherHalf sel_313: sel_311: 4 1 8)
		(otherHalf sel_110: sel_311: 4 1 8)
		(bolt sel_110:)
		(if (IsFlag 41)
			(rm440Door sel_4: 0)
			(otherHalf sel_4: 0)
			(bolt sel_4: 3)
		)
		(chest sel_110:)
		(tapestry sel_110: sel_311: 4 1 8)
		(painting sel_110:)
		(dogArmor sel_110:)
		(genericArmor sel_110:)
		(genericFlag sel_110:)
		(rightDoorway sel_110:)
		(rearDoorway sel_110:)
		(roundWin sel_110:)
		(southExitFeature sel_110:)
		((ScriptID 1881 2) sel_1: 12 sel_0: 85 sel_549: 125 sel_550: 0) ; Laura
	)

	(method (sel_57)
		(super sel_57:)
		(cond
			(sel_142)
			((StepOn gEgo 2)
				(otherHalf sel_63: 10)
				(bolt sel_63: 11)
				(gCurRoom sel_146: sExitEast)
			)
			((StepOn gEgo 8)
				(gCurRoom sel_146: sExitSouth)
			)
		)
	)

	(method (sel_111)
		(DisposeScript 441)
		(DisposeScript 442)
		(DisposeScript 443)
		(DisposeScript 444)
		(if (== gAct 5)
			(DisposeScript 2440)
		)
		(gWalkHandler sel_81: self)
		(gDirectionHandler sel_81: self)
		(super sel_111:)
	)

	(method (sel_133 param1)
		(cond
			(
				(and
					(& (param1 sel_31:) $0040)
					(== (gTheIconBar sel_207:) (gTheIconBar sel_228:))
					(!= (param1 sel_37:) 0)
					(== (gEgo sel_2:) 443)
				)
				(param1 sel_73: 1)
				(gEgo sel_146: sOutTapestry)
			)
			((& (param1 sel_31:) $1000)
				(super sel_133: param1)
			)
			(else
				(return 0)
			)
		)
	)

	(method (sel_300 param1)
		(switch param1
			(3
				(if (== (gEgo sel_2:) 443)
					(gEgo sel_146: sOutTapestry)
				else
					((ScriptID 441 4) sel_137: 1) ; countTimer
				)
			)
			(else
				(super sel_300: param1 &rest)
			)
		)
	)

	(method (sel_403)
		(cond
			((== gAct 5)
				(if
					(and
						(gCurRoom sel_142:)
						(not (== (gCurRoom sel_142:) (ScriptID 444 0))) ; sHeKills
					)
					((gCurRoom sel_142:) sel_65: (ScriptID 444 0)) ; sHeKills
				else
					(gCurRoom sel_146: (ScriptID 444 0)) ; sHeKills
				)
			)
			(
				(and
					(== gAct 3)
					(or (IsFlag 120) (TimeCheck $2020)) ; has 2:00 am occurred?
					(TimeCheck $2020 1) ; can 2:00 am occur?
				)
				(self sel_146: sMeetingNo2)
			)
			((and (== gAct 3) (TimeCheck $1008 1)) ; can 1:00 am occur?
				(LoadMany rsVIEW 444 825)
				(if (== (gEgo sel_2:) 443)
					(gTheIconBar sel_233: 1 2 5 6)
				)
				(gGame sel_587:)
				(if (== (gEgo sel_2:) 443)
					(gGame sel_87: 1 149)
					(self sel_146: (ScriptID 441 0)) ; sCountessMeeting
				else
					(self sel_146: (ScriptID 441 1)) ; sCountessNoMeet
				)
			)
		)
	)
)

(instance sMeetingNo2 of Script
	(properties
		sel_20 {sMeetingNo2}
	)

	(method (sel_144 param1)
		(switch (= sel_29 param1)
			(0
				(= sel_136 1)
			)
			(1
				(if (== (gEgo sel_2:) 443)
					(gTheIconBar sel_233: 1 2 5 6)
				)
				(gGame sel_587:)
				(LoadMany rsVIEW 820 814)
				((ScriptID 90 2) sel_182: 440) ; aOlympia
				(= sel_136 1)
			)
			(2
				((ScriptID 90 2) sel_3: 1 sel_1: 228 sel_0: 133) ; aOlympia
				(if ((ScriptID 90 2) sel_322:) ; aOlympia
					(((ScriptID 90 2) sel_322:) sel_57:) ; aOlympia
				)
				(= sel_136 1)
			)
			(3
				((ScriptID 90 2) sel_2: 820) ; aOlympia
				(= sel_136 3)
			)
			(4
				(if (== (gEgo sel_2:) 443)
					((ScriptID 90 2) sel_146: (ScriptID 442 0) self) ; aOlympia, sOHMeeting
				else
					((ScriptID 90 2) sel_146: (ScriptID 442 1) self) ; aOlympia, sOHNoMeet
				)
			)
			(5
				((ScriptID 90 2) sel_146: (ScriptID 442 2) self) ; aOlympia, sOHLeave
			)
			(6
				(= sel_136 3)
			)
			(7
				(DisposeScript 442)
				(if (== (gEgo sel_2:) 443)
					(gGame sel_588:)
					(gTheIconBar sel_233: 1 2 5 6)
				else
					(gGame sel_588:)
				)
				((ScriptID 90 2) sel_182: 430 sel_619: 1) ; aOlympia
				(self sel_111:)
			)
		)
	)
)

(instance sEnterEast of Script
	(properties
		sel_20 {sEnterEast}
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

(instance sExitEast of Script
	(properties
		sel_20 {sExitEast}
	)

	(method (sel_144 param1)
		(switch (= sel_29 param1)
			(0
				(gGame sel_587:)
				(= sel_136 1)
			)
			(1
				(gEgo sel_312: MoveTo 236 136 self)
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
					(gCurRoom sel_399: 430)
				)
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
				(gEgo sel_312: MoveTo (gEgo sel_1:) 170 self)
			)
			(2
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
				(gEgo sel_312: MoveTo (gEgo sel_1:) 275 self)
			)
			(2
				(gCurRoom sel_399: 490)
			)
		)
	)
)

(instance sHideInTapestry of Script
	(properties
		sel_20 {sHideInTapestry}
	)

	(method (sel_144 param1)
		(switch (= sel_29 param1)
			(0
				(gTheIconBar sel_233: 1 2 5 6)
				(gGame sel_587:)
				(if (not (== gAct 5))
					(WrapMusic sel_168: 1)
					(gGameMusic2 sel_40: 5 sel_99: 1 sel_3: -1 sel_39:)
				)
				(= sel_136 1)
			)
			(1
				(gWalkHandler sel_129: gCurRoom)
				(gDirectionHandler sel_129: gCurRoom)
				(gEgo
					sel_2: 443
					sel_3: 1
					sel_4: 0
					sel_153: 11 147
					sel_161: CT 5 1 self
				)
			)
			(2
				(noise sel_40: 442 sel_99: 1 sel_39:)
				(gEgo sel_161: End self)
			)
			(3
				(gEgo sel_155: 0 sel_4: 0)
				(= sel_136 1)
			)
			(4
				(if
					(or
						(and
							(== gAct 3)
							(TimeCheck $1008 1) ; can 1:00 am occur?
							((ScriptID 90 15) sel_137:) ; meetingTimer
						)
						(and
							(== gAct 3)
							(TimeCheck $2020 1) ; can 2:00 am occur?
							((ScriptID 90 15) sel_137:) ; meetingTimer
						)
					)
					((ScriptID 90 15) sel_137: 1) ; meetingTimer
				else
					(gGame sel_588: 1)
				)
				(southExitFeature sel_111:)
				(self sel_111:)
			)
		)
	)
)

(instance sOutTapestry of Script
	(properties
		sel_20 {sOutTapestry}
	)

	(method (sel_144 param1)
		(switch (= sel_29 param1)
			(0
				(gGame sel_587:)
				(= sel_136 1)
			)
			(1
				(if (== (gCurRoom sel_142:) (ScriptID 441 0)) ; sCountessMeeting
					(gCurRoom sel_142: 0)
				)
				(gEgo sel_161: End self)
				(noise sel_40: 442 sel_99: 1 sel_39:)
			)
			(2
				(gEgo
					sel_585: (if (== gAct 5) 426 else 831)
					sel_153: 20 151
				)
				(if
					(and
						(== ((ScriptID 90 1) sel_620:) 440) ; aCountess
						(TimeCheck $1008) ; has 1:00 am occurred?
						(not (IsFlag 120))
					)
					(gEgo sel_146: (ScriptID 441 3) self) ; sTalkWithCountess
					(self sel_111:)
				else
					(gWalkHandler sel_81: gCurRoom)
					(gDirectionHandler sel_81: gCurRoom)
					(= sel_136 1)
				)
			)
			(3
				(gGameMusic2 sel_170:)
				(if (not (== gAct 5))
					(WrapMusic sel_168: 0)
				)
				(gGame sel_588: 1)
				(southExitFeature sel_110:)
				(gTheIconBar sel_177: 1 2 5 6)
				(self sel_111:)
			)
		)
	)
)

(instance sBoltDoor of Script
	(properties
		sel_20 {sBoltDoor}
	)

	(method (sel_144 param1)
		(switch (= sel_29 param1)
			(0
				(gGame sel_587:)
				(= sel_136 1)
			)
			(1
				(gEgo sel_312: PolyPath 213 146 self)
			)
			(2
				(gEgo
					sel_2: 442
					sel_3: 2
					sel_4: 3
					sel_153: 207 144
					sel_244: 12
					sel_161: Beg self
				)
				(bolt sel_63: (- (gEgo sel_60:) 1))
				(bolt sel_161: End)
			)
			(3
				(noise sel_40: 446 sel_99: 1 sel_3: 1 sel_39:)
				(gEgo sel_2: 831 sel_3: 8 sel_4: 6 sel_153: 213 146)
				(= sel_136 1)
			)
			(4
				(gEgo sel_585: (if (== gAct 5) 426 else 831))
				(= sel_136 1)
			)
			(5
				(bolt sel_313:)
				(if (== gAct 5)
					(= sel_136 1)
				else
					(sel_42 sel_146: sUnBoltDoor)
				)
			)
			(6
				(gGame sel_588:)
				(rm440Door sel_590: 1)
				(if (== gAct 5)
					(PursuitRgn sel_669:)
				)
				(SetFlag 41)
				(self sel_111:)
			)
		)
	)
)

(instance sUnBoltDoor of Script
	(properties
		sel_20 {sUnBoltDoor}
	)

	(method (sel_144 param1)
		(switch (= sel_29 param1)
			(0
				(gGame sel_587:)
				(= sel_136 1)
			)
			(1
				(gEgo sel_312: PolyPath 213 146 self)
			)
			(2
				(gEgo
					sel_2: 442
					sel_3: 2
					sel_4: 0
					sel_153: 207 144
					sel_244: 12
					sel_161: End self
				)
				(bolt sel_161: Beg)
				(noise sel_40: 446 sel_99: 1 sel_3: 1 sel_39:)
			)
			(3
				(gEgo sel_2: 831 sel_3: 8 sel_4: 6 sel_153: 213 146)
				(= sel_136 1)
			)
			(4
				(gEgo sel_585: (if (== gAct 5) 426 else 831))
				(= sel_136 1)
			)
			(5
				(bolt sel_313:)
				(if (== gAct 5)
					(= sel_136 1)
				else
					(gMessager sel_295: 12 4 3 0 self)
				)
			)
			(6
				(gGame sel_588:)
				(rm440Door sel_590: 0)
				(if (== gAct 5)
					(PursuitRgn sel_670:)
				)
				(ClearFlag 41)
				(self sel_111:)
			)
		)
	)
)

(instance otherHalf of Prop
	(properties
		sel_20 {otherHalf}
		sel_1 225
		sel_0 139
		sel_213 12
		sel_303 199
		sel_304 145
		sel_2 440
		sel_3 4
		sel_4 7
		sel_14 16385
	)
)

(instance rm440Door of Door
	(properties
		sel_20 {rm440Door}
		sel_1 211
		sel_0 137
		sel_213 12
		sel_303 199
		sel_304 145
		sel_2 440
		sel_3 3
		sel_4 7
		sel_595 1
		sel_596 0
		sel_597 236
		sel_598 136
	)

	(method (sel_145)
		(super sel_145:)
		(bolt sel_63: 11)
		(otherHalf sel_313:)
		(bolt sel_313:)
	)

	(method (sel_189)
		(bolt sel_63: 15)
		(super sel_189:)
	)

	(method (sel_360)
		(bolt sel_63: 15)
		(super sel_360:)
	)

	(method (sel_606)
		(super sel_606: 205 130 230 134 229 144 206 138)
	)
)

(instance bolt of Prop
	(properties
		sel_20 {bolt}
		sel_1 225
		sel_0 160
		sel_82 45
		sel_213 12
		sel_2 440
		sel_3 5
		sel_60 9
		sel_14 16401
	)

	(method (sel_300 param1)
		(switch param1
			(4
				(cond
					((rm440Door sel_590:)
						(gCurRoom sel_146: sUnBoltDoor)
					)
					((== (rm440Door sel_29:) 2)
						(rm440Door sel_360:)
					)
					(else
						(gCurRoom sel_146: sBoltDoor)
					)
				)
			)
			(else
				(super sel_300: param1 &rest)
			)
		)
	)
)

(instance leftDoor of Feature ; UNUSED
	(properties
		sel_20 {leftDoor}
		sel_1 94
		sel_0 88
		sel_213 6
		sel_6 89
		sel_7 90
		sel_8 134
		sel_9 99
		sel_301 40
	)
)

(instance chest of Feature
	(properties
		sel_20 {chest}
		sel_1 295
		sel_0 140
		sel_213 4
		sel_6 118
		sel_7 271
		sel_8 163
		sel_9 319
		sel_301 40
	)
)

(instance tapestry of Feature
	(properties
		sel_20 {tapestry}
		sel_1 28
		sel_0 91
		sel_213 9
		sel_6 35
		sel_7 5
		sel_8 147
		sel_9 51
		sel_301 40
		sel_303 20
		sel_304 151
	)

	(method (sel_300 param1)
		(switch param1
			(4
				(if
					(and
						(not (== (gEgo sel_2:) 443))
						(or
							(== gAct 5)
							(== (== ((ScriptID 90 1) sel_620:) 440) 0) ; aCountess
						)
					)
					(if (or (== gAct 5) (MuseumRgn sel_646:))
						(gCurRoom sel_146: sHideInTapestry)
					else
						(return 1)
					)
				else
					(super sel_300: param1 &rest)
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
		sel_1 265
		sel_0 95
		sel_213 5
		sel_6 79
		sel_7 255
		sel_8 111
		sel_9 276
		sel_301 40
	)
)

(instance dogArmor of Feature
	(properties
		sel_20 {dogArmor}
		sel_0 100
		sel_213 3
		sel_302 16384
	)
)

(instance genericArmor of Feature
	(properties
		sel_20 {genericArmor}
		sel_0 160
		sel_302 8192
	)

	(method (sel_300 param1)
		(switch param1
			(4
				(gMessager sel_295: 1 4)
			)
			(8
				(gMessager sel_295: 1 8)
			)
			(else
				(super sel_300: param1)
			)
		)
	)

	(method (sel_218 param1)
		(if (super sel_218: param1)
			(cond
				(
					(and
						(< 59 gMouseX)
						(< gMouseX 70)
						(< 83 gMouseY)
						(< gMouseY 143)
					)
					(= sel_213 24)
				)
				(
					(and
						(< 72 gMouseX)
						(< gMouseX 84)
						(< 91 gMouseY)
						(< gMouseY 143)
					)
					(= sel_213 25)
				)
				(
					(and
						(< 86 gMouseX)
						(< gMouseX 100)
						(< 93 gMouseY)
						(< gMouseY 143)
					)
					(= sel_213 26)
				)
				(
					(and
						(< 103 gMouseX)
						(< gMouseX 110)
						(< 105 gMouseY)
						(< gMouseY 134)
					)
					(= sel_213 27)
				)
				(
					(and
						(< 115 gMouseX)
						(< gMouseX 130)
						(< 104 gMouseY)
						(< gMouseY 149)
					)
					(= sel_213 28)
				)
				(
					(and
						(< 171 gMouseX)
						(< gMouseX 185)
						(< 96 gMouseY)
						(< gMouseY 135)
					)
					(= sel_213 30)
				)
				(
					(and
						(< 187 gMouseX)
						(< gMouseX 201)
						(< 91 gMouseY)
						(< gMouseY 137)
					)
					(= sel_213 31)
				)
				(
					(and
						(< 225 gMouseX)
						(< gMouseX 256)
						(< 97 gMouseY)
						(< gMouseY 188)
					)
					(= sel_213 32)
				)
			)
		)
	)
)

(instance genericFlag of Feature
	(properties
		sel_20 {genericFlag}
		sel_0 50
		sel_302 4096
	)

	(method (sel_300 param1)
		(switch param1
			(4
				(gMessager sel_295: 2 4)
			)
			(8
				(gMessager sel_295: 2 8)
			)
			(else
				(super sel_300: param1)
			)
		)
	)

	(method (sel_218 param1)
		(if (super sel_218: param1)
			(cond
				(
					(and
						(<= 45 gMouseX)
						(<= gMouseX 130)
						(<= 0 gMouseY)
						(<= gMouseY 23)
					)
					(= sel_213 14)
				)
				(
					(and
						(<= 76 gMouseX)
						(<= gMouseX 116)
						(<= 25 gMouseY)
						(<= gMouseY 43)
					)
					(= sel_213 15)
				)
				(
					(and
						(<= 92 gMouseX)
						(<= gMouseX 117)
						(<= 44 gMouseY)
						(<= gMouseY 54)
					)
					(= sel_213 16)
				)
				(
					(and
						(<= 95 gMouseX)
						(<= gMouseX 119)
						(<= 56 gMouseY)
						(<= gMouseY 72)
					)
					(= sel_213 17)
				)
				(
					(and
						(<= 99 gMouseX)
						(<= gMouseX 118)
						(<= 72 gMouseY)
						(<= gMouseY 82)
					)
					(= sel_213 18)
				)
				(
					(and
						(<= 106 gMouseX)
						(<= gMouseX 123)
						(<= 83 gMouseY)
						(<= gMouseY 95)
					)
					(= sel_213 19)
				)
				(
					(and
						(<= 154 gMouseX)
						(<= gMouseX 177)
						(<= 64 gMouseY)
						(<= gMouseY 77)
					)
					(= sel_213 20)
				)
				(
					(and
						(<= 148 gMouseX)
						(<= gMouseX 191)
						(<= 39 gMouseY)
						(<= gMouseY 62)
					)
					(= sel_213 21)
				)
				(
					(and
						(<= 139 gMouseX)
						(<= gMouseX 198)
						(<= 0 gMouseY)
						(<= gMouseY 38)
					)
					(= sel_213 22)
				)
				(
					(and
						(<= 215 gMouseX)
						(<= gMouseX 270)
						(<= 0 gMouseY)
						(<= gMouseY 20)
					)
					(= sel_213 23)
				)
			)
		)
	)
)

(instance rightDoorway of Feature
	(properties
		sel_20 {rightDoorway}
		sel_1 218
		sel_0 112
		sel_213 7
		sel_6 85
		sel_7 214
		sel_8 139
		sel_9 223
		sel_301 40
	)
)

(instance rearDoorway of Feature
	(properties
		sel_20 {rearDoorway}
		sel_1 140
		sel_0 116
		sel_213 13
		sel_6 101
		sel_7 111
		sel_8 131
		sel_9 169
		sel_301 40
	)
)

(instance roundWin of Feature
	(properties
		sel_20 {roundWin}
		sel_1 138
		sel_0 82
		sel_213 33
		sel_6 73
		sel_7 125
		sel_8 91
		sel_9 151
		sel_301 40
	)
)

(instance armorPippin of Feature
	(properties
		sel_20 {armorPippin}
		sel_1 151
		sel_0 128
		sel_213 10
		sel_6 96
		sel_7 140
		sel_8 160
		sel_9 164
		sel_301 40
		sel_303 128
		sel_304 165
	)

	(method (sel_300 param1)
		(switch param1
			(1
				(if (== gAct 5)
					(gMessager sel_295: 38)
				else
					(gMessager sel_295: 10 1 2)
				)
			)
			(4
				(if (== gAct 5)
					(gMessager sel_295: 38)
				else
					(gMessager sel_295: 10 4 2)
				)
			)
			(8
				(if (== gAct 5)
					(gMessager sel_295: 38)
				else
					(gMessager sel_295: 10 8 2)
				)
			)
			(else
				(super sel_300: param1)
			)
		)
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

(instance noise of Sound
	(properties
		sel_20 {noise}
		sel_99 1
	)
)
