;;; Sierra Script 1.0 - (do not remove this comment)
(script# 500)
(include sci.sh)
(use Main)
(use LBRoom)
(use ExitFeature)
(use MuseumRgn)
(use Inset)
(use Scaler)
(use PolyPath)
(use Polygon)
(use CueObj)
(use MoveFwd)
(use n958)
(use StopWalk)
(use Sound)
(use Cycle)
(use View)
(use Obj)

(public
	rm500 0
)

(local
	local0
	local1
	theGLb2DoVerbCode
	local3
)
(instance rm500 of LBRoom
	(properties
		sel_20 {rm500}
		sel_213 40
		sel_408 500
		sel_409 420
		sel_411 510
		sel_107 0
	)
	
	(method (sel_110)
		(proc958_0 128 500 504 505 831)
		(Load rsPIC 501)
		(Load rsSOUND 501 19)
		(if (proc0_2 4) (Load rsSOUND 502))
		(if
			(or
				(> global123 4)
				(and (== global123 4) (proc0_10 12548 1))
			)
			(proc958_0 129 556 505)
			(proc958_0 132 500 3 6 84)
		)
		(gEgo
			sel_110:
			sel_585: (if (== global123 5) 426 else 831)
			sel_320: Scaler 100 70 190 120
		)
		(self sel_414: 90)
		(gGame sel_587:)
		(switch gGSel_40
			(sel_409
				(gEgo sel_1: 103 sel_0: 159 sel_253: 180)
				(cond 
					((== global123 5) (self sel_146: sLauraDies))
					(
						(and
							(== global123 3)
							(proc0_10 8512)
							(not (proc0_2 85))
						)
						(if (== ((ScriptID 90 1) sel_620?) gSel_40)
							((ScriptID 90 1) sel_182: -2)
						)
						(if (== ((ScriptID 90 2) sel_620?) gSel_40)
							((ScriptID 90 2) sel_182: -2)
						)
						(self sel_146: sMeeting)
					)
					(else (self sel_146: sEnterNorth))
				)
			)
			(sel_411
				(gEgo sel_1: 260 sel_0: 200 sel_253: 315)
				(self sel_146: sEnterSouth)
			)
			(else 
				(gEgo sel_153: 78 176)
				(gGame sel_588:)
			)
		)
		(super sel_110:)
		(if
			(and
				(== global123 3)
				(proc0_10 8512)
				(not (proc0_2 85))
			)
			(= local3 ((ScriptID 90 3) sel_620?))
			((ScriptID 90 3)
				sel_648: 818
				sel_2: 818
				sel_182: gSel_40
				sel_153: 227 179
				sel_155: 8
				sel_156: 1
			)
			((ScriptID 32 0)
				sel_648: 814
				sel_620: gSel_40
				sel_110:
				sel_153: 206 179
				sel_155: 8
				sel_156: 0
			)
			(WrapMusic sel_168:)
			(gGameMusic2 sel_40: 350 sel_3: -1 sel_99: 1 sel_39:)
		)
		(if
			(or
				(> global123 4)
				(and (== global123 4) (proc0_10 12548 1))
			)
			(yvetteStatue sel_110: sel_313:)
			(global2
				sel_395:
					(= local1
						((Polygon sel_109:)
							sel_31: 2
							sel_110: 135 183 180 183 191 189 142 189
							sel_117:
						)
					)
			)
		)
		(if (not (gEgo sel_238: 8))
			(keyGlint sel_110: sel_311: 4 1 8 sel_146: sKeyGlint)
		)
		(bobPortrait sel_110:)
		(rickPortrait sel_110:)
		(leftWall sel_110:)
		(dennisPortrait sel_110:)
		(suziPortrait sel_110:)
		(boschPortrait sel_110:)
		(erwinPortrait sel_110:)
		(johnPortrait sel_110:)
		(bench sel_110:)
		(sculpture1 sel_110:)
		(sculpture2 sel_110:)
		(ceiling sel_110:)
		(borderCeiling sel_110:)
		(southExitFeature sel_110:)
	)
	
	(method (sel_57)
		(super sel_57:)
		(cond 
			(sel_142)
			((proc0_1 gEgo 2) (gEgo sel_349: 1) (self sel_399: sel_409))
		)
	)
	
	(method (sel_399 param1)
		(cond 
			(
			(and (== global123 3) (proc0_2 85) (proc0_10 128)) (= param1 26))
			((== global123 2) (gGameMusic2 sel_167:) (gSel_608 sel_168: 0))
			(
				(or
					(> global123 4)
					(and (== global123 4) (proc0_10 12548 1))
				)
				(local1 sel_111:)
			)
		)
		(super sel_399: param1)
	)
)

(instance sLauraDies of Script
	(properties
		sel_20 {sLauraDies}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gEgo sel_312: PolyPath 152 166 self)
			)
			(1
				(proc0_5 gEgo oRiley)
				(oRiley
					sel_110:
					sel_2: 423
					sel_153: 99 150
					sel_320: 165
					sel_253: 180
					sel_161: StopWalk -1
					sel_312: PolyPath 124 161 self
				)
			)
			(2
				(oRiley
					sel_2: 424
					sel_153: (+ (oRiley sel_1?) 4) (oRiley sel_0?)
					sel_155: 0
					sel_156: 0
					sel_161: End self
				)
			)
			(3
				(gEgo sel_312: 0 sel_2: 858 sel_155: 4 sel_161: End self)
				(sFX sel_40: 80 sel_99: 5 sel_39:)
			)
			(4 (= sel_139 60))
			(5
				(= global145 0)
				(global2 sel_399: 99)
				(self sel_111:)
			)
		)
	)
)

(instance oRiley of Actor
	(properties
		sel_20 {oRiley}
		sel_1 227
		sel_0 179
		sel_2 818
		sel_3 8
		sel_4 1
	)
)

(instance yvetteStatue of Prop
	(properties
		sel_20 {yvetteStatue}
		sel_1 150
		sel_0 141
		sel_213 8
		sel_303 185
		sel_304 187
		sel_2 504
		sel_60 15
		sel_14 16
	)
	
	(method (sel_110)
		(if
			(or
				(> global123 4)
				(and (== global123 4) (proc0_10 12548))
			)
			(self sel_4: 8 sel_313:)
		)
		(super sel_110: &rest)
	)
	
	(method (sel_300 param1)
		(return
			(switch param1
				(29
					(if
						(not
							(cond 
								((> global123 4))
								((== global123 4) (proc0_10 12548))
							)
						)
						(if (MuseumRgn sel_646:)
							(global2 sel_146: sSmashPlaster)
						else
							(return 1)
						)
					)
				)
				(1
					(if
					(== (yvetteStatue sel_4?) (yvetteStatue sel_246:))
						(global2 sel_146: sDeadYvette)
					else
						(gLb2Messager sel_295: 8 1)
					)
				)
				(8
					(if
					(== (yvetteStatue sel_4?) (yvetteStatue sel_246:))
						(global2 sel_146: sDeadYvette)
					else
						(gLb2Messager sel_295: 8 8)
					)
				)
				(else  (super sel_300: param1))
			)
		)
	)
)

(instance keyGlint of Prop
	(properties
		sel_20 {keyGlint}
		sel_1 267
		sel_0 116
		sel_213 20
		sel_2 500
		sel_244 12
	)
	
	(method (sel_218 param1 param2 &tmp temp0 temp1)
		(if (IsObject param1)
			(= temp0 (param1 sel_1?))
			(= temp1 (param1 sel_0?))
		else
			(= temp0 param1)
			(= temp1 param2)
		)
		(return
			(and
				(<= 250 temp0 284)
				(<= 100 temp1 130)
			)
		)
	)
	
	(method (sel_300 param1)
		(switch param1
			(1
				(global2 sel_146: sBoschPainting)
			)
			(8
				(global2 sel_146: sBoschPainting)
			)
			(else 
				(super sel_300: param1 &rest)
			)
		)
	)
)

(instance keyGlintInset of Prop
	(properties
		sel_20 {keyGlintInset}
		sel_1 198
		sel_0 91
		sel_213 21
		sel_2 500
		sel_244 12
	)
	
	(method (sel_218 param1 param2 &tmp temp0 temp1)
		(if (IsObject param1)
			(= temp0 (param1 sel_1?))
			(= temp1 (param1 sel_0?))
		else
			(= temp0 param1)
			(= temp1 param2)
		)
		(return
			(and
				(<= 170 temp0 226)
				(<= 70 temp1 112)
			)
		)
	)
	
	(method (sel_300 param1)
		(switch param1
			(1
				(inBoschPainting sel_422: inSkeletonKey)
			)
			(4
				(inBoschPainting sel_422: inSkeletonKey)
			)
			(8
				(inBoschPainting sel_422: inSkeletonKey)
			)
			(else 
				(super sel_300: param1 &rest)
			)
		)
	)
)

(instance lauraSwingingRt of Actor
	(properties
		sel_20 {lauraSwingingRt}
		sel_1 185
		sel_0 187
		sel_2 504
		sel_3 1
		sel_4 8
	)
)

(instance lauraSwingingLt of Actor
	(properties
		sel_20 {lauraSwingingLt}
		sel_1 136
		sel_0 185
		sel_2 504
		sel_3 2
		sel_4 9
	)
)

(instance bobPortrait of Feature
	(properties
		sel_20 {bobPortrait}
		sel_1 50
		sel_0 128
		sel_213 2
		sel_6 106
		sel_7 33
		sel_8 151
		sel_9 67
		sel_301 40
	)
	
	(method (sel_300 param1)
		(switch param1
			(4 (gLb2Messager sel_295: 24 4))
			(else  (super sel_300: param1))
		)
	)
)

(instance rickPortrait of Feature
	(properties
		sel_20 {rickPortrait}
		sel_1 153
		sel_0 113
		sel_213 4
		sel_6 102
		sel_7 136
		sel_8 124
		sel_9 170
		sel_301 40
	)
	
	(method (sel_300 param1)
		(switch param1
			(4 (gLb2Messager sel_295: 24 4))
			(else  (super sel_300: param1))
		)
	)
)

(instance leftWall of Feature
	(properties
		sel_20 {leftWall}
		sel_0 1
		sel_213 7
		sel_301 40
		sel_302 4
	)
)

(instance dennisPortrait of Feature
	(properties
		sel_20 {dennisPortrait}
		sel_1 200
		sel_0 1
		sel_213 3
		sel_301 40
		sel_302 256
	)
	
	(method (sel_300 param1)
		(switch param1
			(4 (gLb2Messager sel_295: 24 4))
			(else  (super sel_300: param1))
		)
	)
)

(instance suziPortrait of Feature
	(properties
		sel_20 {suziPortrait}
		sel_1 240
		sel_0 1
		sel_213 5
		sel_301 40
		sel_302 8
	)
	
	(method (sel_300 param1)
		(switch param1
			(4 (gLb2Messager sel_295: 24 4))
			(else  (super sel_300: param1))
		)
	)
)

(instance boschPortrait of Feature
	(properties
		sel_20 {boschPortrait}
		sel_1 270
		sel_0 100
		sel_213 9
		sel_301 40
		sel_302 16
	)
	
	(method (sel_300 param1)
		(switch param1
			(8
				(global2 sel_146: sBoschPainting)
			)
			(else
				(super sel_300: param1 &rest)
			)
		)
	)
)

(instance skeletonKey of Feature
	(properties
		sel_20 {skeletonKey}
		sel_1 270
		sel_0 100
		sel_213 17
		sel_301 40
		sel_302 16
	)
	
	(method (sel_300 param1)
		(switch param1
			(1
				(global2 sel_146: sBoschPainting)
			)
			(8
				(global2 sel_146: sBoschPainting)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance erwinPortrait of Feature
	(properties
		sel_20 {erwinPortrait}
		sel_1 380
		sel_0 100
		sel_213 6
		sel_301 40
		sel_302 32
	)
	
	(method (sel_300 param1)
		(switch param1
			(4 (gLb2Messager sel_295: 24 4))
			(else  (super sel_300: param1))
		)
	)
)

(instance johnPortrait of Feature
	(properties
		sel_20 {johnPortrait}
		sel_1 380
		sel_0 160
		sel_213 1
		sel_301 40
		sel_302 64
	)
	
	(method (sel_300 param1)
		(switch param1
			(4 (gLb2Messager sel_295: 24 4))
			(else  (super sel_300: param1))
		)
	)
)

(instance bench of Feature
	(properties
		sel_20 {bench}
		sel_0 1
		sel_213 10
		sel_301 40
		sel_302 128
	)
)

(instance sculpture1 of Feature
	(properties
		sel_20 {sculpture1}
		sel_0 1
		sel_213 11
		sel_301 40
		sel_302 1024
	)
	
	(method (sel_300 param1)
		(switch param1
			(4 (gLb2Messager sel_295: 25 4))
			(else  (super sel_300: param1))
		)
	)
)

(instance sculpture2 of Feature
	(properties
		sel_20 {sculpture2}
		sel_0 1
		sel_213 12
		sel_301 40
		sel_302 512
	)
	
	(method (sel_300 param1)
		(switch param1
			(4 (gLb2Messager sel_295: 25 4))
			(else  (super sel_300: param1))
		)
	)
)

(instance ceiling of Feature
	(properties
		sel_20 {ceiling}
		sel_0 1
		sel_213 13
		sel_301 40
		sel_302 2048
	)
)

(instance borderCeiling of Feature
	(properties
		sel_20 {borderCeiling}
		sel_0 1
		sel_213 14
		sel_301 40
		sel_302 4096
	)
)

(instance inDeadYvette of Inset
	(properties
		sel_20 {inDeadYvette}
		sel_408 505
		sel_60 12
	)
	
	(method (sel_110)
		(super sel_110: &rest)
		(proc0_3 68)
		(proc0_3 161)
		(= theGLb2DoVerbCode gLb2DoVerbCode)
		(= gLb2DoVerbCode exitDoVerbCode)
		(proc0_8 1)
		(gLb2WH sel_129: self)
		(gIconBar sel_233: 7)
		(if (not (gEgo sel_238: 26)) (bifocals sel_110:))
		(if (not (gEgo sel_238: 27)) (redHair sel_110:))
		(feHair sel_110:)
		(feScarf sel_110:)
		(feFace sel_110:)
		(feDress sel_110:)
		(feCleavage sel_110:)
		(feBody sel_110:)
		(feLtHand sel_110:)
		(feRtHand sel_110:)
		(feTowel sel_110:)
	)
	
	(method (sel_111)
		(gLb2WH sel_81: self)
		(gIconBar sel_177: 7)
		(super sel_111:)
	)
	
	(method (sel_300 param1)
		(switch param1
			(13
				(= gLb2DoVerbCode theGLb2DoVerbCode)
				(self sel_111:)
			)
			(else 
				(super sel_300: param1 &rest)
			)
		)
	)
)

(instance exitDoVerbCode of Code
	(properties
		sel_20 {exitDoVerbCode}
	)
	
	(method (sel_57 param1 param2)
		(if (== param1 13)
			(= gLb2DoVerbCode theGLb2DoVerbCode)
			(inDeadYvette sel_111:)
		else
			(proc0_6 param2 param1)
		)
	)
)

(instance bifocals of View
	(properties
		sel_20 {bifocals}
		sel_1 102
		sel_0 156
		sel_213 22
		sel_2 505
		sel_60 13
		sel_14 16400
	)
	
	(method (sel_300 param1)
		(switch param1
			(8
				(if (not (gEgo sel_238: 26))
					(inDeadYvette sel_422: inBifocals)
				)
			)
			(else 
				(super sel_300: param1 &rest)
			)
		)
	)
)

(instance inBifocals of Inset
	(properties
		sel_20 {inBifocals}
		sel_2 505
		sel_3 1
		sel_1 90
		sel_0 135
		sel_570 1
		sel_213 37
	)
	
	(method (sel_110)
		(super sel_110: &rest)
		(if (not (gEgo sel_238: 26))
			(bifocals sel_102:)
			(viBifocals sel_110:)
		)
	)
)

(instance viBifocals of View
	(properties
		sel_20 {viBifocals}
		sel_1 103
		sel_0 156
		sel_213 38
		sel_2 505
		sel_3 1
		sel_4 1
		sel_60 15
		sel_14 16400
	)
	
	(method (sel_111)
		(if (not (gEgo sel_238: 26)) (bifocals sel_216:))
		(super sel_111:)
	)
	
	(method (sel_300 param1)
		(switch param1
			(4
				(gGame sel_87: 1 162)
				((ScriptID 21 0) sel_57: 795)
				(gEgo sel_350: 26)
				(bifocals sel_111:)
				(inBifocals sel_111:)
				(self sel_111:)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance redHair of View
	(properties
		sel_20 {redHair}
		sel_1 161
		sel_0 152
		sel_213 23
		sel_2 505
		sel_3 2
		sel_60 13
		sel_14 16400
	)
	
	(method (sel_300 param1)
		(switch param1
			(8
				(if (not (gEgo sel_238: 27))
					(inDeadYvette sel_422: inRedHair)
				)
			)
			(else 
				(super sel_300: param1 &rest)
			)
		)
	)
)

(instance inRedHair of Inset
	(properties
		sel_20 {inRedHair}
		sel_2 505
		sel_3 3
		sel_1 144
		sel_0 146
		sel_570 1
		sel_213 35
	)
	
	(method (sel_110)
		(super sel_110: &rest)
		(if (not (gEgo sel_238: 27))
			(redHair sel_102:)
			(viRedHair sel_110:)
		)
	)
)

(instance viRedHair of View
	(properties
		sel_20 {viRedHair}
		sel_1 155
		sel_0 155
		sel_213 39
		sel_2 505
		sel_3 3
		sel_4 1
		sel_60 15
		sel_14 16400
	)
	
	(method (sel_111)
		(if (not (gEgo sel_238: 27)) (redHair sel_216:))
		(super sel_111:)
	)
	
	(method (sel_300 param1)
		(switch param1
			(4
				(gGame sel_87: 1 160)
				(gEgo sel_350: 27)
				((ScriptID 21 0) sel_57: 796)
				(redHair sel_111:)
				(self sel_111:)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance feHair of Feature
	(properties
		sel_20 {feHair}
		sel_0 1
		sel_213 29
		sel_301 40
		sel_302 16384
	)
)

(instance feScarf of Feature
	(properties
		sel_20 {feScarf}
		sel_0 1
		sel_213 30
		sel_301 40
		sel_302 8192
	)
)

(instance feFace of Feature
	(properties
		sel_20 {feFace}
		sel_0 1
		sel_213 31
		sel_301 40
		sel_302 4096
	)
)

(instance feDress of Feature
	(properties
		sel_20 {feDress}
		sel_0 1
		sel_213 32
		sel_301 40
		sel_302 2048
	)
)

(instance feCleavage of Feature
	(properties
		sel_20 {feCleavage}
		sel_0 1
		sel_213 33
		sel_301 40
		sel_302 1024
	)
)

(instance feBody of Feature
	(properties
		sel_20 {feBody}
		sel_0 1
		sel_213 34
		sel_301 40
		sel_302 512
	)
)

(instance feLtHand of Feature
	(properties
		sel_20 {feLtHand}
		sel_0 1
		sel_213 35
		sel_301 40
		sel_302 256
	)
)

(instance feRtHand of Feature
	(properties
		sel_20 {feRtHand}
		sel_0 1
		sel_213 36
		sel_301 40
		sel_302 128
	)
)

(instance feTowel of Feature
	(properties
		sel_20 {feTowel}
		sel_0 1
		sel_213 37
		sel_301 40
		sel_302 64
	)
)

(instance inBoschPainting of Inset
	(properties
		sel_20 {inBoschPainting}
		sel_408 501
		sel_560 1
		sel_213 19
	)
	
	(method (sel_110)
		(super sel_110: &rest)
		(proc0_8 1)
		(gLb2WH sel_129: self)
		(if (not (gEgo sel_238: 8))
			(keyGlintInset sel_110: sel_146: sKeyGlintInset)
		)
	)
	
	(method (sel_111)
		(gLb2WH sel_81: self)
		(super sel_111:)
	)
	
	(method (sel_300 param1)
		(switch param1
			(13 (self sel_111:))
			(else 
				(super sel_300: param1 &rest)
			)
		)
	)
)

(instance inSkeletonKey of Inset
	(properties
		sel_20 {inSkeletonKey}
		sel_2 500
		sel_3 1
		sel_1 179
		sel_0 93
		sel_570 1
		sel_213 18
	)
	
	(method (sel_300 param1)
		(return
			(switch param1
				(22
					(if (MuseumRgn sel_646:)
						(gGame sel_87: 1 146)
						(gEgo sel_350: -1 8)
						((ScriptID 21 0) sel_57: 777)
						(sFX sel_40: 501 sel_39:)
						(keyGlintInset sel_111:)
						(keyGlint sel_146: 0)
						(gLb2Messager sel_295: 18 22)
						(self sel_111:)
						(return 1)
					else
						(return 1)
					)
				)
				(21
					(if (MuseumRgn sel_646:)
						(gGame sel_87: 1 146)
						(gEgo sel_350: -1 8)
						((ScriptID 21 0) sel_57: 777)
						(sFX sel_40: 501 sel_39:)
						(keyGlintInset sel_111:)
						(keyGlint sel_146: 0)
						(gLb2Messager sel_295: 18 21)
						(self sel_111:)
						(return 1)
					else
						(return 1)
					)
				)
				(25
					(gLb2Messager sel_295: 18 25)
				)
				(else 
					(super sel_300: param1 &rest)
				)
			)
		)
	)
)

(instance sMeeting of Script
	(properties
		sel_20 {sMeeting}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(gEgo sel_312: MoveFwd 15 self)
				(= sel_136 5)
			)
			(1
				(gLb2Messager sel_295: 3 0 0 0 self 1500)
			)
			(2)
			(3
				(gEgo sel_312: PolyPath 166 179 self)
			)
			(4 (= sel_136 3))
			(5
				(gLb2Messager sel_295: 2 0 0 0 self 1500)
			)
			(6
				((ScriptID 32 0) sel_253: 270 self)
			)
			(7
				(gLb2Messager sel_295: 1 0 0 0 self 1500)
			)
			(8 (gEgo sel_253: 180 self))
			(9
				(if (proc0_10 128)
					(gGameMusic2 sel_40: 502 sel_3: 1 sel_99: 1 sel_39: self)
				)
				(gEgo sel_312: MoveFwd 70 self)
			)
			(10
				(if (not (proc0_10 128))
					(gGameMusic2 sel_170:)
					(WrapMusic sel_168: 0)
					(= sel_136 1)
				)
			)
			(11
				(proc0_3 85)
				((ScriptID 90 3) sel_182: local3)
				(global2 sel_399: (global2 sel_411?))
				(self sel_111:)
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
				(gEgo sel_312: MoveFwd 20 self)
			)
			(1
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
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(if (== global123 2)
					((ScriptID 32 0)
						sel_648: 814
						sel_620: gSel_40
						sel_110:
						sel_153: 130 180
						sel_155: 8
						sel_156: 3
						sel_213: 1
					)
					(gSel_608 sel_168:)
					(gGameMusic2 sel_40: 19 sel_99: 1 sel_155: 1 sel_39:)
				)
				(gEgo sel_312: MoveFwd 15 self)
			)
			(1
				(if (gSel_561 sel_122: (ScriptID 32 0))
					(proc0_5 (ScriptID 32 0) gEgo self)
				else
					(= sel_136 1)
				)
			)
			(2 (= sel_136 5))
			(3
				(if (> global123 2)
					(if
						(not
							(if (and (== global123 3) (proc0_10 8512))
								(not (proc0_2 85))
							)
						)
						(gGame sel_588:)
					)
					(self sel_111:)
				else
					(gLb2Messager sel_295: 3 0 84 0 self 1889)
				)
			)
			(4
				(gEgo
					sel_312: PolyPath (gEgo sel_1?) (- (gEgo sel_0?) 15) self
				)
			)
			(5
				(global2 sel_399: (global2 sel_409?))
			)
		)
	)
)

(instance sSmashPlaster of Script
	(properties
		sel_20 {sSmashPlaster}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(gEgo sel_312: PolyPath 185 187 self)
			)
			(1
				(gEgo sel_2: 504 sel_3: 1 sel_4: 0 sel_161: CT 10 1 self)
			)
			(2
				(gEgo sel_161: End self)
				(sFX sel_40: 500 sel_39:)
				(yvetteStatue sel_161: End self)
			)
			(3 0)
			(4
				((ScriptID 22 0) sel_57: 12548)
				(gGame sel_87: 1 161)
				(gEgo sel_585: 831)
				(yvetteStatue sel_313:)
				(gGame sel_588:)
				(self sel_111:)
			)
		)
	)
)

(instance sDeadYvette of Script
	(properties
		sel_20 {sDeadYvette}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gIconBar sel_233: 7)
				(gSel_561 sel_119: 102)
				(gEgo sel_313:)
				(WrapMusic sel_168: 1)
				(if (proc0_2 68)
					(fooSound sel_40: 6 sel_3: -1 sel_99: 1 sel_39:)
					(= sel_136 1)
				else
					(proc0_3 68)
					(proc0_3 161)
					(global2 sel_417: 556)
					(wrapMusic sel_110: -1 3 6)
					(= local0 1)
					(sFX sel_40: 84 sel_99: 5 sel_3: 1 sel_39:)
					(= sel_139 180)
				)
			)
			(1
				(global2 sel_422: inDeadYvette self)
			)
			(2
				(gEgo sel_315:)
				(gSel_561 sel_119: 216)
				(global2 sel_417: 500)
				(= sel_136 1)
			)
			(3
				(fooSound sel_170: 0 12 30 1)
				(if local0 (wrapMusic sel_111: 1))
				(WrapMusic sel_168: 0)
				(proc0_8 0)
				(gIconBar sel_177: 7)
				(self sel_111:)
			)
		)
	)
)

(instance sBoschPainting of Script
	(properties
		sel_20 {sBoschPainting}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(global2 sel_422: inBoschPainting self)
			)
			(1
				(if (gEgo sel_238: 8) (keyGlint sel_111:))
				(= sel_136 1)
			)
			(2 (proc0_8 0) (self sel_111:))
		)
	)
)

(instance sKeyGlint of Script
	(properties
		sel_20 {sKeyGlint}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0 (= sel_136 2))
			(1 (= sel_139 300))
			(2
				(if
				(and (> (gEgo sel_0?) 168) (< (gEgo sel_0?) 187))
					(keyGlint sel_156: 0 sel_161: End)
					(= sel_139 (* 60 (Random 3 10)))
				else
					(= sel_136 1)
				)
			)
			(3 (self sel_144: 2))
		)
	)
)

(instance sKeyGlintInset of Script
	(properties
		sel_20 {sKeyGlintInset}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(keyGlintInset sel_156: 0 sel_161: End)
				(= sel_139 (* 60 (Random 2 5)))
			)
			(1 (self sel_144: 0))
		)
	)
)

(instance wrapMusic of WrapMusic
	(properties
		sel_20 {wrapMusic}
	)
	
	(method (sel_110)
		(= sel_608 fooSound)
		(super sel_110: &rest)
	)
)

(instance fooSound of Sound
	(properties
		sel_20 {fooSound}
	)
)

(instance sFX of Sound
	(properties
		sel_20 {sFX}
		sel_99 1
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
		sel_213 26
	)
)
