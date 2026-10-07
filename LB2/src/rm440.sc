;;; Sierra Script 1.0 - (do not remove this comment)
(script# 440)
(include sci.sh)
(use Main)
(use Door)
(use LBRoom)
(use ExitFeature)
(use MuseumRgn)
(use PursuitRgn)
(use Scaler)
(use PolyPath)
(use CueObj)
(use MoveFwd)
(use n958)
(use Sound)
(use Cycle)
(use View)
(use Obj)

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
		(proc958_0 128 432 424 423 858 831 426 442 440 443)
		(proc958_0 132 442 440)
		(gEgo
			sel_110:
			sel_585: (if (== global123 5) 426 else 831)
			sel_320: Scaler 155 0 190 90
		)
		(if (== global123 5)
			(self sel_414: 94)
			(global2 sel_259: (List sel_109:))
			((ScriptID 2440 0) sel_57: (global2 sel_259?))
			(if (not (proc0_2 45)) ((ScriptID 94 1) sel_137: 1))
		else
			(self sel_414: 90)
		)
		(switch gGSel_40
			(sel_409
				(gEgo sel_1: 171 sel_0: 148)
				(if (proc0_2 47) (global2 sel_146: (ScriptID 444 0)))
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
		(if (and (== global123 4) (proc0_10 16648 1))
			((ScriptID 443 1) sel_317:)
			(if (not (gEgo sel_238: 12))
				((ScriptID 443 0) sel_110: sel_311: 4 1 8)
			)
		)
		(if (and (> global123 2) (not (== global123 5)))
			((ScriptID 443 4) sel_110: sel_311: 4 1 8)
		else
			(armorPippin
				sel_110:
				sel_311: (if (== global123 5) 0 else 4 1 8)
			)
		)
		(rm440Door
			sel_110:
			sel_594: otherHalf
			sel_313:
			sel_311: 4 1 8
		)
		(otherHalf sel_110: sel_311: 4 1 8)
		(bolt sel_110:)
		(if (proc0_2 41)
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
		((ScriptID 1881 2)
			sel_1: 12
			sel_0: 85
			sel_549: 125
			sel_550: 0
		)
	)
	
	(method (sel_57)
		(super sel_57:)
		(cond 
			(sel_142)
			((proc0_1 gEgo 2)
				(otherHalf sel_63: 10)
				(bolt sel_63: 11)
				(global2 sel_146: sExitEast)
			)
			((proc0_1 gEgo 8) (global2 sel_146: sExitSouth))
		)
	)
	
	(method (sel_111)
		(DisposeScript 441)
		(DisposeScript 442)
		(DisposeScript 443)
		(DisposeScript 444)
		(if (== global123 5) (DisposeScript 2440))
		(gLb2WH sel_81: self)
		(gLb2DH sel_81: self)
		(super sel_111:)
	)
	
	(method (sel_133 param1)
		(return
			(cond 
				(
					(and
						(& (param1 sel_31?) $0040)
						(== (gIconBar sel_207?) (gIconBar sel_228?))
						(!= (param1 sel_37?) 0)
						(== (gEgo sel_2?) 443)
					)
					(param1 sel_73: 1)
					(gEgo sel_146: sOutTapestry)
				)
				((& (param1 sel_31?) $1000) (super sel_133: param1))
				(else (return 0))
			)
		)
	)
	
	(method (sel_300 param1)
		(switch param1
			(3
				(if (== (gEgo sel_2?) 443)
					(gEgo sel_146: sOutTapestry)
				else
					((ScriptID 441 4) sel_137: 1)
				)
			)
			(else 
				(super sel_300: param1 &rest)
			)
		)
	)
	
	(method (sel_403)
		(cond 
			((== global123 5)
				(if
					(and
						(global2 sel_142?)
						(not (== (global2 sel_142?) (ScriptID 444 0)))
					)
					((global2 sel_142?) sel_65: (ScriptID 444 0))
				else
					(global2 sel_146: (ScriptID 444 0))
				)
			)
			((and (== global123 3) (proc0_10 8224 1)) (self sel_146: sMeetingNo2))
			((and (== global123 3) (proc0_10 4104 1))
				(proc958_0 128 444 825)
				(if (== (gEgo sel_2?) 443) (gIconBar sel_233: 1 2 5 6))
				(gGame sel_587:)
				(if (== (gEgo sel_2?) 443)
					(gGame sel_87: 1 149)
					(self sel_146: (ScriptID 441 0))
				else
					(self sel_146: (ScriptID 441 1))
				)
			)
		)
	)
)

(instance sMeetingNo2 of Script
	(properties
		sel_20 {sMeetingNo2}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0 (= sel_136 1))
			(1
				(if (== (gEgo sel_2?) 443) (gIconBar sel_233: 1 2 5 6))
				(gGame sel_587:)
				(proc958_0 128 820 814)
				((ScriptID 90 2) sel_182: 440)
				(= sel_136 1)
			)
			(2
				((ScriptID 90 2) sel_3: 1 sel_1: 228 sel_0: 133)
				(if ((ScriptID 90 2) sel_322?)
					(((ScriptID 90 2) sel_322?) sel_57:)
				)
				(= sel_136 1)
			)
			(3
				((ScriptID 90 2) sel_2: 820)
				(= sel_136 3)
			)
			(4
				(if (== (gEgo sel_2?) 443)
					((ScriptID 90 2) sel_146: (ScriptID 442 0) self)
				else
					((ScriptID 90 2) sel_146: (ScriptID 442 1) self)
				)
			)
			(5
				((ScriptID 90 2) sel_146: (ScriptID 442 2) self)
			)
			(6 (= sel_136 3))
			(7
				(DisposeScript 442)
				(if (== (gEgo sel_2?) 443)
					(gGame sel_588:)
					(gIconBar sel_233: 1 2 5 6)
				else
					(gGame sel_588:)
				)
				((ScriptID 90 2) sel_182: 430 sel_619: 1)
				(self sel_111:)
			)
		)
	)
)

(instance sEnterEast of Script
	(properties
		sel_20 {sEnterEast}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
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
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
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
						(== global123 3)
						(proc0_10 -20222 1)
						(not (proc0_2 72))
					)
					(global2 sel_399: 435)
				else
					(global2 sel_399: 430)
				)
			)
		)
	)
)

(instance sEnterSouth of Script
	(properties
		sel_20 {sEnterSouth}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(= sel_136 1)
			)
			(1
				(gEgo sel_312: MoveTo (gEgo sel_1?) 170 self)
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
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(= sel_136 1)
			)
			(1
				(gEgo sel_312: MoveTo (gEgo sel_1?) 275 self)
			)
			(2 (global2 sel_399: 490))
		)
	)
)

(instance sHideInTapestry of Script
	(properties
		sel_20 {sHideInTapestry}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gIconBar sel_233: 1 2 5 6)
				(gGame sel_587:)
				(if (not (== global123 5))
					(WrapMusic sel_168: 1)
					(gGameMusic2 sel_40: 5 sel_99: 1 sel_3: -1 sel_39:)
				)
				(= sel_136 1)
			)
			(1
				(gLb2WH sel_129: global2)
				(gLb2DH sel_129: global2)
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
							(== global123 3)
							(proc0_10 4104 1)
							((ScriptID 90 15) sel_137?)
						)
						(and
							(== global123 3)
							(proc0_10 8224 1)
							((ScriptID 90 15) sel_137?)
						)
					)
					((ScriptID 90 15) sel_137: 1)
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
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(= sel_136 1)
			)
			(1
				(if (== (global2 sel_142?) (ScriptID 441 0))
					(global2 sel_142: 0)
				)
				(gEgo sel_161: End self)
				(noise sel_40: 442 sel_99: 1 sel_39:)
			)
			(2
				(gEgo
					sel_585: (if (== global123 5) 426 else 831)
					sel_153: 20 151
				)
				(if
					(and
						(== ((ScriptID 90 1) sel_620?) 440)
						(proc0_10 4104)
						(not (proc0_10 4880))
						(not (proc0_2 120))
					)
					(gEgo sel_146: (ScriptID 441 3) self)
					(self sel_111:)
				else
					(gLb2WH sel_81: global2)
					(gLb2DH sel_81: global2)
					(= sel_136 1)
				)
			)
			(3
				(gGameMusic2 sel_170:)
				(if (not (== global123 5)) (WrapMusic sel_168: 0))
				(gGame sel_588: 1)
				(southExitFeature sel_110:)
				(gIconBar sel_177: 1 2 5 6)
				(self sel_111:)
			)
		)
	)
)

(instance sBoltDoor of Script
	(properties
		sel_20 {sBoltDoor}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
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
				(bolt sel_63: (- (gEgo sel_60?) 1))
				(bolt sel_161: End)
			)
			(3
				(noise sel_40: 446 sel_99: 1 sel_3: 1 sel_39:)
				(gEgo sel_2: 831 sel_3: 8 sel_4: 6 sel_153: 213 146)
				(= sel_136 1)
			)
			(4
				(gEgo sel_585: (if (== global123 5) 426 else 831))
				(= sel_136 1)
			)
			(5
				(bolt sel_313:)
				(if (== global123 5)
					(= sel_136 1)
				else
					(sel_42 sel_146: sUnBoltDoor)
				)
			)
			(6
				(gGame sel_588:)
				(rm440Door sel_590: 1)
				(if (== global123 5) (PursuitRgn sel_669:))
				(proc0_3 41)
				(self sel_111:)
			)
		)
	)
)

(instance sUnBoltDoor of Script
	(properties
		sel_20 {sUnBoltDoor}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
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
				(gEgo sel_585: (if (== global123 5) 426 else 831))
				(= sel_136 1)
			)
			(5
				(bolt sel_313:)
				(if (== global123 5)
					(= sel_136 1)
				else
					(gLb2Messager sel_295: 12 4 3 0 self)
				)
			)
			(6
				(gGame sel_588:)
				(rm440Door sel_590: 0)
				(if (== global123 5) (PursuitRgn sel_670:))
				(proc0_4 41)
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
					((rm440Door sel_590?) (global2 sel_146: sUnBoltDoor))
					((== (rm440Door sel_29?) 2) (rm440Door sel_360:))
					(else (global2 sel_146: sBoltDoor))
				)
			)
			(else 
				(super sel_300: param1 &rest)
			)
		)
	)
)

(instance leftDoor of Feature
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
		(return
			(switch param1
				(4
					(if
						(and
							(not (== (gEgo sel_2?) 443))
							(or
								(== global123 5)
								(== (== ((ScriptID 90 1) sel_620?) 440) 0)
							)
						)
						(if (or (== global123 5) (MuseumRgn sel_646:))
							(global2 sel_146: sHideInTapestry)
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
			(4 (gLb2Messager sel_295: 1 4))
			(8 (gLb2Messager sel_295: 1 8))
			(else  (super sel_300: param1))
		)
	)
	
	(method (sel_218 param1)
		(if (super sel_218: param1)
			(cond 
				(
					(and
						(< 59 gSel_1)
						(< gSel_1 70)
						(< 83 gSel_0)
						(< gSel_0 143)
					)
					(= sel_213 24)
				)
				(
					(and
						(< 72 gSel_1)
						(< gSel_1 84)
						(< 91 gSel_0)
						(< gSel_0 143)
					)
					(= sel_213 25)
				)
				(
					(and
						(< 86 gSel_1)
						(< gSel_1 100)
						(< 93 gSel_0)
						(< gSel_0 143)
					)
					(= sel_213 26)
				)
				(
					(and
						(< 103 gSel_1)
						(< gSel_1 110)
						(< 105 gSel_0)
						(< gSel_0 134)
					)
					(= sel_213 27)
				)
				(
					(and
						(< 115 gSel_1)
						(< gSel_1 130)
						(< 104 gSel_0)
						(< gSel_0 149)
					)
					(= sel_213 28)
				)
				(
					(and
						(< 171 gSel_1)
						(< gSel_1 185)
						(< 96 gSel_0)
						(< gSel_0 135)
					)
					(= sel_213 30)
				)
				(
					(and
						(< 187 gSel_1)
						(< gSel_1 201)
						(< 91 gSel_0)
						(< gSel_0 137)
					)
					(= sel_213 31)
				)
				(
					(and
						(< 225 gSel_1)
						(< gSel_1 256)
						(< 97 gSel_0)
						(< gSel_0 188)
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
			(4 (gLb2Messager sel_295: 2 4))
			(8 (gLb2Messager sel_295: 2 8))
			(else  (super sel_300: param1))
		)
	)
	
	(method (sel_218 param1)
		(if (super sel_218: param1)
			(cond 
				(
					(and
						(<= 45 gSel_1)
						(<= gSel_1 130)
						(<= 0 gSel_0)
						(<= gSel_0 23)
					)
					(= sel_213 14)
				)
				(
					(and
						(<= 76 gSel_1)
						(<= gSel_1 116)
						(<= 25 gSel_0)
						(<= gSel_0 43)
					)
					(= sel_213 15)
				)
				(
					(and
						(<= 92 gSel_1)
						(<= gSel_1 117)
						(<= 44 gSel_0)
						(<= gSel_0 54)
					)
					(= sel_213 16)
				)
				(
					(and
						(<= 95 gSel_1)
						(<= gSel_1 119)
						(<= 56 gSel_0)
						(<= gSel_0 72)
					)
					(= sel_213 17)
				)
				(
					(and
						(<= 99 gSel_1)
						(<= gSel_1 118)
						(<= 72 gSel_0)
						(<= gSel_0 82)
					)
					(= sel_213 18)
				)
				(
					(and
						(<= 106 gSel_1)
						(<= gSel_1 123)
						(<= 83 gSel_0)
						(<= gSel_0 95)
					)
					(= sel_213 19)
				)
				(
					(and
						(<= 154 gSel_1)
						(<= gSel_1 177)
						(<= 64 gSel_0)
						(<= gSel_0 77)
					)
					(= sel_213 20)
				)
				(
					(and
						(<= 148 gSel_1)
						(<= gSel_1 191)
						(<= 39 gSel_0)
						(<= gSel_0 62)
					)
					(= sel_213 21)
				)
				(
					(and
						(<= 139 gSel_1)
						(<= gSel_1 198)
						(<= 0 gSel_0)
						(<= gSel_0 38)
					)
					(= sel_213 22)
				)
				(
					(and
						(<= 215 gSel_1)
						(<= gSel_1 270)
						(<= 0 gSel_0)
						(<= gSel_0 20)
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
				(if (== global123 5)
					(gLb2Messager sel_295: 38)
				else
					(gLb2Messager sel_295: 10 1 2)
				)
			)
			(4
				(if (== global123 5)
					(gLb2Messager sel_295: 38)
				else
					(gLb2Messager sel_295: 10 4 2)
				)
			)
			(8
				(if (== global123 5)
					(gLb2Messager sel_295: 38)
				else
					(gLb2Messager sel_295: 10 8 2)
				)
			)
			(else  (super sel_300: param1))
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
