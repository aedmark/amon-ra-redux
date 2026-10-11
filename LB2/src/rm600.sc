;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 600)
(include sci.sh)
(use Main)
(use Door)
(use eRS)
(use ExitFeature)
(use n027)
(use MuseumRgn)
(use Inset)
(use Scaler)
(use PolyPath)
(use Feature)
(use Timer)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm600 0
	northDoor 1
	eastDoor 2
)

(local
	local0
	local1
	local2
	local3
)

(instance rm600 of LBRoom
	(properties
		sel_20 {rm600}
		sel_213 6
		sel_408 600
		sel_409 650
		sel_410 610
		sel_411 530
		sel_108 40
	)

	(method (sel_110)
		(gEgo sel_110: sel_585: 831 sel_320: Scaler 102 0 190 40)
		(self sel_414: 90)
		(switch gPrevRoomNum
			(521 ; meanWhile
				(gGame sel_587:)
				(gEgo sel_153: 160 170)
				(self sel_146: sOlympiaEnters)
			)
			(sel_409
				(gEgo sel_349: 0 sel_253: 180)
				(gGameMusic2 sel_167:)
			)
			(sel_411
				(gEgo sel_1: 160)
				(gGameMusic2 sel_170:)
				(gGame sel_588:)
			)
			(sel_410
				(gEgo sel_349: 0 sel_253: 270)
				(eastDoor sel_143: self)
				(gGameMusic2 sel_167:)
			)
			(else
				(gEgo sel_584: 1 sel_153: 160 170)
				(gGame sel_588:)
			)
		)
		(WrapMusic sel_168: 0)
		(super sel_110:)
		(if (IsFlag 10)
			(glass sel_311: 4 1 sel_156: (glass sel_246:) sel_110:)
			(if (not (gEgo sel_238: 15))
				(lantern
					sel_311: 1 4
					sel_63: 14
					sel_0: (+ (lantern sel_0:) 50)
					sel_82: 50
					sel_110:
				)
			)
		else
			(glass sel_311: 4 1 sel_110:)
			(lantern sel_311: 1 4 sel_110:)
			(Load rsSOUND 600)
		)
		(northDoor sel_311: 4 sel_110:)
		(doorbell sel_311: 4 sel_110:)
		(eastDoor sel_311: 4 sel_110:)
		(columnA sel_110:)
		(columnB sel_110:)
		(columnC sel_110:)
		(columnD sel_110:)
		(archA sel_110:)
		(archB sel_110:)
		(ceiling sel_110:)
		(southExit sel_110:)
		(if (not (IsFlag 16))
			(Load rsSOUND 637)
			(ferret sel_110:)
			(ferretTimer sel_162: ferret (Random 15 45))
		else
			(ClearFlag 16)
		)
		(if (and (IsFlag 12) (not (IsFlag 61)))
			(Load rsVIEW 635)
			(Load rsSOUND 636)
			(meatTimer sel_162: bugsWithMeat 5)
		)
		(if
			(and
				(== gAct 4)
				(not (== gPrevRoomNum 521)) ; meanWhile
				(not (IsFlag 62))
				(TimeCheck $4108 1) ; can 4:15 am occur?
				(not (IsFlag 92))
			)
			(SetFlag 62)
			(self sel_146: sMeanwhile)
		)
		(if (and (not (IsFlag 84)) (== ((ScriptID 90 2) sel_620:) gCurRoomNum)) ; aOlympia
			((ScriptID 90 2) sel_618: 650) ; aOlympia
		)
	)

	(method (sel_57)
		(super sel_57:)
		(cond
			(sel_142 0)
			((StepOn gEgo 2)
				(self sel_146: sExitToStairs)
			)
		)
	)

	(method (sel_111)
		(ferretTimer sel_111: sel_81:)
		(meatTimer sel_111: sel_81:)
		(if local0
			(ClearFlag 10)
		)
		(WrapMusic sel_168: 1)
		(super sel_111:)
	)

	(method (sel_399)
		(super sel_399: &rest)
		(if
			(and
				(or (== gNewRoomNum sel_409) (== gNewRoomNum sel_411))
				(not (IsFlag 4))
			)
			(cond
				((not (TimeCheck $b102)) 0) ; has 11:15 pm occurred?
				((not (TimeCheck $1310)) ; has 1:45 am occurred?
					(ClearFlag 18)
				)
				(else 0)
			)
		)
		(if (!= gNewRoomNum sel_409)
			(ClearFlag 117)
		)
	)
)

(instance sExitToStairs of Script
	(properties
		sel_20 {sExitToStairs}
	)

	(method (sel_144 param1)
		(switch (= sel_29 param1)
			(0
				(gGame sel_587:)
				(gEgo sel_312: MoveTo 330 (gEgo sel_0:) self)
			)
			(1
				(gCurRoom sel_399: (gCurRoom sel_411:))
			)
		)
	)
)

(instance sBreakGlass of Script
	(properties
		sel_20 {sBreakGlass}
	)

	(method (sel_144 param1 &tmp temp0 temp1)
		(switch (= sel_29 param1)
			(0
				(gGame sel_587:)
				(gEgo sel_312: PolyPath 55 188 self)
			)
			(1
				(if (== sel_141 29)
					(= temp0 48)
					(= temp1 175)
				else
					(= temp0 41)
					(= temp1 176)
				)
				(gEgo sel_312: MoveTo temp0 temp1 self)
			)
			(2
				(gEgo
					sel_2: 601
					sel_155: (if (== sel_141 29) 1 else 2)
					sel_156: 0
					sel_63: 15
					sel_161: End self
				)
			)
			(3
				(sFX sel_40: 600 sel_99: 5 sel_3: 1 sel_39:)
				(glass sel_161: CT 3 1 self)
			)
			(4
				(lantern sel_63: 14 sel_0: (+ (lantern sel_0:) 50) sel_82: 50)
				(glass sel_161: End self)
			)
			(5
				(SetFlag 10)
				(glass sel_313:)
				(gEgo sel_585: 831 sel_312: MoveTo 59 187 self)
			)
			(6
				(gEgo sel_253: 270 self)
			)
			(7
				(cond
					((IsFlag 109)
						(gGame sel_588:)
						(self sel_111:)
					)
					((and (IsFlag 108) (not (Random 0 2)))
						(Load rsVIEW 814)
						(Load rsSOUND 19)
						(SetFlag 109)
						(self sel_146: sTakeAwayLantern)
					)
					((and (not (IsFlag 108)) (Random 0 1))
						(Load rsVIEW 814)
						(Load rsSOUND 19)
						(SetFlag 108)
						(self sel_146: sTakeAwayLantern)
					)
					(else
						(gGame sel_588:)
						(self sel_111:)
					)
				)
			)
		)
	)
)

(instance sTakeAwayLantern of Script
	(properties
		sel_20 {sTakeAwayLantern}
	)

	(method (sel_144 param1)
		(switch (= sel_29 param1)
			(0
				(if (and (!= gPrevRoomNum 650) (IsFlag 83))
					(self sel_146: sHeimlichFromOffice self)
				else
					((ScriptID 32 0) ; aHeimlich
						sel_110:
						sel_320: Scaler 120 0 190 0
						sel_2: 814
						sel_620: gCurRoomNum
						sel_153: 197 250
						sel_312: PolyPath 79 186 self
					)
					(WrapMusic sel_168: 1)
					(gGameMusic2 sel_40: 19 sel_99: 1 sel_3: -1 sel_39:)
				)
			)
			(1
				(gEgo sel_253: 90 self)
			)
			(2
				(= sel_136 3)
			)
			(3
				(gMessager sel_295: 7 0 0 0 self)
			)
			(4
				(gEgo sel_312: PolyPath (gEgo sel_1:) 240 self)
			)
			(5
				(= local0 1)
				(gGameMusic2 sel_170:)
				(gCurRoom sel_399: (gCurRoom sel_411:))
				(self sel_111:)
			)
		)
	)
)

(instance sHeimlichFromOffice of Script
	(properties
		sel_20 {sHeimlichFromOffice}
	)

	(method (sel_144 param1)
		(switch (= sel_29 param1)
			(0
				(= sel_136 2)
			)
			(1
				(northDoor sel_590: 1)
				((ScriptID 32 0) ; aHeimlich
					sel_110:
					sel_320: 170
					sel_2: 814
					sel_620: gCurRoomNum
					sel_63: 6
					sel_253: 180
					sel_153: (northDoor sel_597:) (northDoor sel_598:)
				)
				(WrapMusic sel_168: 1)
				(gGameMusic2 sel_40: 19 sel_99: 1 sel_3: -1 sel_39:)
				(northDoor sel_161: End self)
				(sFX sel_40: 46 sel_99: 5 sel_3: 1 sel_39:)
				(global95 sel_81: (northDoor sel_603:))
			)
			(2
				((ScriptID 32 0) ; aHeimlich
					sel_63: -1
					sel_312:
						PolyPath
						(northDoor sel_303:)
						(northDoor sel_304:)
						self
				)
			)
			(3
				(northDoor sel_161: Beg self)
				(sFX sel_40: 47 sel_99: 5 sel_3: 1 sel_39:)
				(global95 sel_118: (northDoor sel_603:))
			)
			(4
				((ScriptID 32 0) sel_312: PolyPath 79 186 self) ; aHeimlich
			)
			(5
				((ScriptID 32 0) sel_253: 270 self) ; aHeimlich
			)
			(6
				(self sel_111:)
			)
		)
	)
)

(instance sFerretRight of Script
	(properties
		sel_20 {sFerretRight}
	)

	(method (sel_144 param1)
		(switch (= sel_29 param1)
			(0
				(ferret sel_155: 5 sel_161: Walk sel_312: PolyPath 243 173 self)
				(sFXFerret sel_39:)
			)
			(1
				(if (eastDoor sel_4:)
					(ferret
						sel_312:
							PolyPath
							(eastDoor sel_597:)
							(eastDoor sel_598:)
							self
					)
				else
					(ferret sel_312: PolyPath 347 210 self)
				)
			)
			(2
				(ferret sel_111:)
				(self sel_111:)
			)
		)
	)
)

(instance sFerretLeft of Script
	(properties
		sel_20 {sFerretLeft}
	)

	(method (sel_144 param1)
		(switch (= sel_29 param1)
			(0
				(if (eastDoor sel_4:)
					(ferret
						sel_153: (eastDoor sel_597:) (eastDoor sel_598:)
						sel_155: 4
						sel_161: Walk
						sel_312: PolyPath 243 173 self
					)
				else
					(ferret
						sel_153: 347 210
						sel_155: 4
						sel_161: Walk
						sel_312: PolyPath 243 173 self
					)
				)
				(sFXFerret sel_39:)
			)
			(1
				(ferret sel_312: PolyPath 21 210 self)
			)
			(2
				(ferret sel_111:)
				(self sel_111:)
			)
		)
	)
)

(instance sDoMeat of Script
	(properties
		sel_20 {sDoMeat}
	)

	(method (sel_144 param1)
		(switch (= sel_29 param1)
			(0
				(gGame sel_587:)
				(sFXBeetles sel_39: 0 sel_170: 127 25 10 0 self)
			)
			(1
				(sFX sel_40: 46 sel_99: 5 sel_39:)
				(eastDoor sel_161: End self)
				(global95 sel_81: (eastDoor sel_603:))
			)
			(2
				(bugsWithMeat
					sel_110:
					sel_153: (eastDoor sel_597:) (eastDoor sel_598:)
					sel_155: 0
					sel_161: Walk
					sel_312:
						PolyPath
						(eastDoor sel_303:)
						(eastDoor sel_304:)
						self
				)
			)
			(3
				(sFX sel_40: 47 sel_99: 5 sel_39:)
				(eastDoor sel_161: Beg self)
				(global95 sel_118: (eastDoor sel_603:))
			)
			(4
				(gGame sel_588:)
				(bugsWithMeat sel_312: PolyPath 243 173 self)
			)
			(5
				(bugsWithMeat sel_312: PolyPath 21 210 self)
			)
			(6
				(sFXBeetles sel_170:)
				(SetFlag 61)
				(bugsWithMeat sel_111:)
				(self sel_111:)
			)
		)
	)
)

(instance sOlympiaEnters of Script
	(properties
		sel_20 {sOlympiaEnters}
	)

	(method (sel_144 param1)
		(switch (= sel_29 param1)
			(0
				(= sel_136 15)
			)
			(1
				(olympia
					sel_153: 100 210
					sel_161: Walk
					sel_320: Scaler 102 0 190 40
					sel_63: -1
					sel_312:
						PolyPath
						(- (gEgo sel_1:) 20)
						(gEgo sel_0:)
						self
					sel_110:
				)
				(= sel_137 2)
			)
			(2
				(Face gEgo olympia)
			)
			(3
				(Face gEgo olympia self)
			)
			(4
				(gMessager sel_295: 1 0 24 0 self 1892)
			)
			(5
				(olympia sel_312: PolyPath 285 176 self)
			)
			(6
				(eastDoor sel_161: End self)
				(global95 sel_81: (eastDoor sel_603:))
			)
			(7
				(olympia sel_312: PolyPath 314 157 self)
			)
			(8
				(global95 sel_118: (eastDoor sel_603:))
				(eastDoor sel_161: Beg self)
			)
			(9
				(gGame sel_588:)
				(olympia sel_111:)
				(ClearFlag 62)
				(self sel_111:)
			)
		)
	)
)

(instance ferret of Actor
	(properties
		sel_20 {ferret}
		sel_1 21
		sel_0 210
		sel_2 632
		sel_3 5
		sel_14 16384
		sel_244 4
		sel_51 4
		sel_53 4
	)

	(method (sel_300 param1)
		(switch param1
			(6
				(switch (gCurRoom sel_422: (ScriptID 20 0)) ; inNotebook
					(259
						(if (proc27_0 12 global298)
							(gMessager sel_295: 1 6 1 0 0 1894)
						else
							(gMessager sel_295: 1 6 4 0 0 1894)
							(proc27_1 12 @global298)
						)
					)
					(260
						(if (proc27_0 12 global299)
							(gMessager sel_295: 1 6 1 0 0 1894)
						else
							(gMessager sel_295: 1 6 5 0 0 1894)
							(proc27_1 12 @global299)
						)
					)
					(265
						(if (proc27_0 12 global304)
							(gMessager sel_295: 1 6 1 0 0 1894)
						else
							(gMessager sel_295: 1 6 10 0 0 1894)
							(proc27_1 12 @global304)
						)
					)
					(266
						(if (proc27_0 12 global305)
							(gMessager sel_295: 1 6 1 0 0 1894)
						else
							(gMessager sel_295: 1 6 11 0 0 1894)
							(proc27_1 12 @global305)
						)
					)
					(270
						(if (proc27_0 12 global309)
							(gMessager sel_295: 1 6 1 0 0 1894)
						else
							(gMessager sel_295: 1 6 15 0 0 1894)
							(proc27_1 12 @global309)
						)
					)
					(781
						(if (proc27_0 12 global333)
							(gMessager sel_295: 1 6 1 0 0 1894)
						else
							(gMessager sel_295: 1 6 39 0 0 1894)
							(proc27_1 12 @global333)
						)
					)
					(785
						(if (proc27_0 12 global337)
							(gMessager sel_295: 1 6 1 0 0 1894)
						else
							(gMessager sel_295: 1 6 43 0 0 1894)
							(proc27_1 12 @global337)
						)
					)
					(800
						(if (proc27_0 12 global352)
							(gMessager sel_295: 1 6 1 0 0 1894)
						else
							(gMessager sel_295: 1 6 58 0 0 1894)
							(proc27_1 12 @global352)
						)
					)
					(else
						(gMessager sel_295: 1 6 81 0 0 1894)
					)
				)
			)
			(41
				(gMessager sel_295: 1 41 0 0 0 1894)
			)
			(8
				(gMessager sel_295: 1 8 0 0 0 1894)
			)
			(19
				(gMessager sel_295: 1 19 0 0 0 1894)
			)
			(24
				(gMessager sel_295: 1 24 0 0 0 1894)
			)
			(25
				(gMessager sel_295: 1 25 0 0 0 1894)
			)
			(23
				(gMessager sel_295: 1 23 0 0 0 1894)
			)
			(2
				(gMessager sel_295: 1 2 0 0 0 1894)
			)
			(4
				(gMessager sel_295: 1 4 0 0 0 1894)
			)
			(1
				(gMessager sel_295: 1 1 0 0 0 1894)
			)
			(else
				(gMessager sel_295: 1 0 0 0 0 1894)
			)
		)
	)

	(method (sel_145)
		(SetFlag 16)
		(if (Random 0 1)
			(self sel_146: sFerretLeft)
		else
			(self sel_146: sFerretRight)
		)
	)
)

(instance ferretTimer of Timer
	(properties
		sel_20 {ferretTimer}
	)
)

(instance bugsWithMeat of Actor
	(properties
		sel_20 {bugsWithMeat}
		sel_213 12
		sel_2 635
		sel_14 16384
	)

	(method (sel_300 param1)
		(switch param1
			(6
				(gMessager sel_295: 12 2)
			)
			(else
				(if (not (OneOf param1 3 1 4 2))
					(gMessager sel_295: 12)
				else
					(super sel_300: param1)
				)
			)
		)
	)

	(method (sel_145)
		(if (gCurRoom sel_142:)
			(meatTimer sel_162: self 5)
		else
			(self sel_146: sDoMeat)
		)
	)
)

(instance meatTimer of Timer
	(properties
		sel_20 {meatTimer}
	)
)

(instance lantern of View
	(properties
		sel_20 {lantern}
		sel_1 22
		sel_0 150
		sel_303 55
		sel_304 188
		sel_2 600
		sel_60 13
		sel_14 17
	)

	(method (sel_300 param1)
		(switch param1
			(4
				(lantern sel_111:)
				(gEgo sel_350: 15)
				((ScriptID 21 0) sel_57: 784) ; addCluesCode
			)
			(1
				(gCurRoom sel_422: inLantern)
			)
			(8
				(gCurRoom sel_422: inLantern)
			)
			(else
				(super sel_300: param1)
			)
		)
	)
)

(instance olympia of Actor
	(properties
		sel_20 {olympia}
		sel_1 256
		sel_0 184
		sel_2 820
		sel_4 5
		sel_60 13
		sel_14 16400
	)
)

(instance glass of Prop
	(properties
		sel_20 {glass}
		sel_1 17
		sel_0 159
		sel_213 5
		sel_303 55
		sel_304 188
		sel_2 601
		sel_60 13
		sel_14 16401
		sel_244 9
	)

	(method (sel_300 param1)
		(switch param1
			(1
				(if (IsFlag 10)
					(gMessager sel_295: 5 1 5)
				else
					(gMessager sel_295: 5 1 4)
				)
			)
			(8
				(if (IsFlag 10)
					(super sel_300: param1)
				else
					(gMessager sel_295: 5 8 4)
				)
			)
			(4
				(if (IsFlag 10)
					(gMessager sel_295: 5 4 5)
				else
					(gMessager sel_295: 5 4 4)
				)
			)
			(29
				(cond
					((IsFlag 10)
						(gMessager sel_295: 5 29 5)
					)
					((MuseumRgn sel_646:)
						(gCurRoom sel_146: sBreakGlass 0 29)
					)
					(else
						(return 1)
					)
				)
			)
			(23
				(cond
					((IsFlag 10)
						(super sel_300: param1)
					)
					((MuseumRgn sel_646:)
						(gCurRoom sel_146: sBreakGlass 0 23)
					)
					(else
						(return 1)
					)
				)
			)
			(22
				(if (IsFlag 10)
					(super sel_300: param1)
				else
					(gMessager sel_295: 5 22 4)
				)
			)
			(41
				(if (IsFlag 10)
					(super sel_300: param1)
				else
					(gMessager sel_295: 5 41 4)
				)
			)
			(19
				(if (IsFlag 10)
					(super sel_300: param1)
				else
					(gMessager sel_295: 5 19 4)
				)
			)
			(18
				(if (IsFlag 10)
					(super sel_300: param1)
				else
					(gMessager sel_295: 5 18 4)
				)
			)
			(21
				(if (IsFlag 10)
					(super sel_300: param1)
				else
					(gMessager sel_295: 5 21 4)
				)
			)
			(else
				(super sel_300: param1)
			)
		)
	)
)

(instance northDoor of Door
	(properties
		sel_20 {northDoor}
		sel_1 152
		sel_0 109
		sel_213 8
		sel_303 134
		sel_304 174
		sel_2 600
		sel_3 1
		sel_589 650
		sel_593 38
		sel_597 134
		sel_598 155
		sel_599 0
		sel_600 0
	)

	(method (sel_110)
		(super sel_110:)
		(self sel_311: 4 38)
	)

	(method (sel_605)
		(cond
			((or (IsFlag 84) (== gPrevRoomNum (gCurRoom sel_409:)) local3)
				(super sel_605: &rest)
			)
			((IsFlag 83)
				(gMessager sel_295: 1 38 4 0 0 1600)
				(northDoor sel_590: 1)
				(SetFlag 84)
			)
			((IsFlag 82)
				(gMessager sel_295: 1 38 3 0 0 1600)
				(northDoor sel_590: 1)
				(SetFlag 83)
				(= local3 1)
			)
			((IsFlag 81)
				(gMessager sel_295: 1 38 2 0 0 1600)
				(northDoor sel_590: 1)
				(SetFlag 82)
				(= local3 1)
			)
			(else
				(gMessager sel_295: 1 38 1 0 0 1600)
				(northDoor sel_590: 1)
				(SetFlag 81)
			)
		)
	)

	(method (sel_606)
		(super sel_606: 109 161 109 149 161 149 161 161 112 161)
	)
)

(instance eastDoor of Door
	(properties
		sel_20 {eastDoor}
		sel_1 290
		sel_0 96
		sel_213 9
		sel_303 269
		sel_304 175
		sel_2 600
		sel_3 2
		sel_589 610
		sel_597 310
		sel_598 158
		sel_599 0
		sel_600 0
	)

	(method (sel_606)
		(super sel_606: 285 152 306 157 305 164 282 159)
	)
)

(instance inLantern of Inset
	(properties
		sel_20 {inLantern}
		sel_2 600
		sel_4 1
		sel_0 128
		sel_570 1
	)

	(method (sel_300 param1)
		(switch param1
			(1
				(gMessager sel_295: 19 1 0 0 0 15)
			)
			(8
				(gMessager sel_295: 19 8 0 0 0 15)
			)
			(4
				(lantern sel_111:)
				(gEgo sel_350: 15)
				((ScriptID 21 0) sel_57: 784) ; addCluesCode
				(self sel_111:)
			)
			(else
				(super sel_300: param1)
			)
		)
	)
)

(instance doorbell of Feature
	(properties
		sel_20 {doorbell}
		sel_1 112
		sel_0 138
		sel_213 2
		sel_6 133
		sel_7 109
		sel_8 142
		sel_9 116
		sel_301 40
		sel_303 115
		sel_304 170
	)

	(method (sel_300 param1)
		(switch param1
			(4
				(gMessager sel_295: 2 4)
			)
			(else
				(super sel_300: param1)
			)
		)
	)
)

(instance columnA of Feature
	(properties
		sel_20 {columnA}
		sel_1 99
		sel_0 116
		sel_213 1
		sel_6 67
		sel_7 89
		sel_8 165
		sel_9 109
		sel_301 40
	)

	(method (sel_300 param1)
		(switch param1
			(1
				(switch local1
					(0
						(gMessager sel_295: 1 1 1)
					)
					(1
						(gMessager sel_295: 1 1 2)
					)
					(else
						(gMessager sel_295: 1 1 3)
					)
				)
				(++ local1)
			)
			(4
				(gMessager sel_295: 1 4)
			)
			(else
				(super sel_300: param1)
			)
		)
	)
)

(instance columnB of Feature
	(properties
		sel_20 {columnB}
		sel_1 179
		sel_0 116
		sel_213 1
		sel_6 72
		sel_7 169
		sel_8 161
		sel_9 189
		sel_301 40
	)

	(method (sel_300)
		(columnA sel_300: &rest)
	)
)

(instance columnC of Feature
	(properties
		sel_20 {columnC}
		sel_1 234
		sel_0 179
		sel_213 1
		sel_7 217
		sel_8 189
		sel_9 251
		sel_301 40
	)

	(method (sel_300)
		(columnA sel_300: &rest)
	)
)

(instance columnD of Feature
	(properties
		sel_20 {columnD}
		sel_1 312
		sel_0 101
		sel_213 1
		sel_6 25
		sel_7 306
		sel_8 177
		sel_9 319
		sel_301 40
	)

	(method (sel_300)
		(columnA sel_300: &rest)
	)
)

(instance archA of Feature
	(properties
		sel_20 {archA}
		sel_1 134
		sel_0 96
		sel_213 10
		sel_6 87
		sel_7 114
		sel_8 105
		sel_9 154
		sel_301 40
	)
)

(instance archB of Feature
	(properties
		sel_20 {archB}
		sel_1 293
		sel_0 86
		sel_213 10
		sel_6 79
		sel_7 288
		sel_8 93
		sel_9 299
		sel_301 40
	)
)

(instance ceiling of Feature
	(properties
		sel_20 {ceiling}
		sel_1 136
		sel_0 28
		sel_213 3
		sel_7 57
		sel_8 56
		sel_9 216
		sel_301 40
	)

	(method (sel_300 param1)
		(switch param1
			(1
				(switch local2
					(0
						(gMessager sel_295: 3 1 1)
					)
					(else
						(gMessager sel_295: 3 1 2)
					)
				)
				(++ local2)
			)
			(else
				(super sel_300: param1)
			)
		)
	)
)

(instance southExit of ExitFeature
	(properties
		sel_20 {southExit}
		sel_6 185
		sel_7 46
		sel_8 189
		sel_9 319
		sel_33 11
		sel_583 3
		sel_213 4
	)
)

(instance sFX of Sound
	(properties
		sel_20 {sFX}
		sel_99 1
	)
)

(instance sFXBeetles of Sound
	(properties
		sel_20 {sFXBeetles}
		sel_99 1
		sel_40 636
		sel_3 -1
	)
)

(instance sFXFerret of Sound
	(properties
		sel_20 {sFXFerret}
		sel_99 1
		sel_40 637
	)
)

(instance sMeanwhile of Script
	(properties
		sel_20 {sMeanwhile}
	)

	(method (sel_144 param1)
		(switch (= sel_29 param1)
			(0
				(gGame sel_587:)
				(switch gPrevRoomNum
					((gCurRoom sel_409:)
						(gEgo sel_349: 0 sel_253: 180)
						(gGameMusic2 sel_167:)
					)
					((gCurRoom sel_411:)
						(gEgo sel_1: 160)
					)
					((gCurRoom sel_410:)
						(gEgo sel_349: 0 sel_253: 270)
						(eastDoor sel_143: self)
						(gGameMusic2 sel_167:)
					)
					(else
						(gEgo sel_584: 1 sel_153: 160 170)
					)
				)
				(= sel_136 1)
			)
			(1
				(gCurRoom sel_399: 521)
			)
		)
	)
)
