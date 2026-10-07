;;; Sierra Script 1.0 - (do not remove this comment)
(script# 565)
(include sci.sh)
(use Main)
(use Door)
(use LBRoom)
(use Inset)
(use Scaler)
(use PolyPath)
(use CueObj)
(use n958)
(use StopWalk)
(use Sound)
(use Cycle)
(use View)
(use Obj)

(public
	rm565 0
)

(local
	local0
	local1
	theGLb2DoVerbCode
	theGSel_561
)
(instance rm565 of LBRoom
	(properties
		sel_20 {rm565}
		sel_409 666
		sel_412 550
	)
	
	(method (sel_110)
		(gEgo
			sel_110:
			sel_585: 831
			sel_316:
			sel_320: Scaler 130 0 190 0
		)
		(proc958_0 128 560 561 562 563 564 565 831)
		(proc958_0 132 2 6 721)
		(proc958_0 129 465 565)
		(self sel_414: 90)
		(switch gGSel_40
			(sel_409
				(global2 sel_146: sEnterTunnel)
			)
			(sel_412
				(gEgo sel_1: 8 sel_0: 150)
			)
		)
		(super sel_110:)
		(if (proc0_2 66)
			(global2 sel_146: sDeadWatney)
		else
			(global2 sel_408: 560 sel_417: 560)
			(deskClock sel_317:)
			(deadWatney sel_317:)
			(calendar sel_317:)
			(intercom sel_317:)
			(phoneList sel_317:)
			(phone sel_317:)
			(safePic sel_110: sel_313:)
			(xWestDoor sel_110:)
			(if (== gGSel_40 sel_409)
				(Palette palSET_INTENSITY 0 255 100)
				(self sel_146: sEnterTunnel)
			else
				(secretDoor sel_110: sel_313:)
				(self sel_146: sEgoEnter)
			)
		)
	)
	
	(method (sel_111)
		(DisposeScript 2565)
		(super sel_111: &rest)
	)
)

(instance deskClock of View
	(properties
		sel_20 {deskClock}
		sel_1 128
		sel_0 114
		sel_213 41
		sel_303 89
		sel_304 185
		sel_2 563
		sel_3 4
		sel_4 5
		sel_60 11
		sel_14 16
	)
)

(instance deadWatney of View
	(properties
		sel_20 {deadWatney}
		sel_1 137
		sel_0 114
		sel_2 560
		sel_60 11
		sel_14 16400
	)
)

(instance calendar of View
	(properties
		sel_20 {calendar}
		sel_1 120
		sel_0 118
		sel_213 44
		sel_303 99
		sel_304 178
		sel_2 563
		sel_3 4
		sel_4 1
		sel_60 12
		sel_14 16
	)
)

(instance intercom of View
	(properties
		sel_20 {intercom}
		sel_1 132
		sel_0 122
		sel_213 42
		sel_303 93
		sel_304 171
		sel_2 563
		sel_3 4
		sel_4 3
		sel_60 12
		sel_14 16
	)
)

(instance phoneList of View
	(properties
		sel_20 {phoneList}
		sel_1 109
		sel_0 123
		sel_213 43
		sel_2 563
		sel_3 4
		sel_60 12
		sel_14 16
	)
)

(instance phone of View
	(properties
		sel_20 {phone}
		sel_1 83
		sel_0 118
		sel_213 58
		sel_2 563
		sel_3 4
		sel_4 6
		sel_60 12
		sel_14 16
	)
)

(instance safePic of View
	(properties
		sel_20 {safePic}
		sel_1 82
		sel_0 100
		sel_213 77
		sel_303 93
		sel_304 149
		sel_2 564
		sel_3 1
		sel_60 6
		sel_14 16
	)
)

(instance secretDoor of Prop
	(properties
		sel_20 {secretDoor}
		sel_1 294
		sel_0 147
		sel_2 560
		sel_3 2
		sel_244 12
	)
)

(instance bloodDrip of Prop
	(properties
		sel_20 {bloodDrip}
		sel_1 152
		sel_0 125
		sel_213 78
		sel_214 560
		sel_2 565
	)
)

(instance feCpBlood of Feature
	(properties
		sel_20 {feCpBlood}
		sel_0 1
		sel_213 61
		sel_214 560
		sel_301 40
		sel_302 16384
	)
	
	(method (sel_300 param1)
		(switch param1
			(8
				(global2 sel_422: inFeCpBlood)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance feQuills of Feature
	(properties
		sel_20 {feQuills}
		sel_0 1
		sel_213 62
		sel_214 560
		sel_301 40
		sel_302 8192
	)
)

(instance fePorcupine of Feature
	(properties
		sel_20 {fePorcupine}
		sel_0 1
		sel_213 63
		sel_214 560
		sel_301 40
		sel_302 4096
	)
)

(instance feHead of Feature
	(properties
		sel_20 {feHead}
		sel_0 1
		sel_213 64
		sel_214 560
		sel_301 40
		sel_302 2048
	)
)

(instance feHandLeft of Feature
	(properties
		sel_20 {feHandLeft}
		sel_0 1
		sel_213 65
		sel_214 560
		sel_301 40
		sel_302 1024
	)
)

(instance feHandRight of Feature
	(properties
		sel_20 {feHandRight}
		sel_0 1
		sel_213 66
		sel_214 560
		sel_301 40
		sel_302 512
	)
)

(instance feIntercom of Feature
	(properties
		sel_20 {feIntercom}
		sel_0 1
		sel_213 67
		sel_214 560
		sel_301 40
		sel_302 256
	)
)

(instance feClockBroken of Feature
	(properties
		sel_20 {feClockBroken}
		sel_0 1
		sel_213 53
		sel_214 560
		sel_301 40
		sel_302 128
	)
)

(instance feCalendar of Feature
	(properties
		sel_20 {feCalendar}
		sel_0 1
		sel_213 51
		sel_214 560
		sel_301 40
		sel_302 64
	)
)

(instance feBody of Feature
	(properties
		sel_20 {feBody}
		sel_0 1
		sel_213 70
		sel_214 560
		sel_301 40
		sel_302 32
	)
)

(instance feDrawerBig of Feature
	(properties
		sel_20 {feDrawerBig}
		sel_0 1
		sel_213 71
		sel_214 560
		sel_301 40
		sel_302 16
	)
)

(instance feDrawerTop of Feature
	(properties
		sel_20 {feDrawerTop}
		sel_0 1
		sel_213 72
		sel_214 560
		sel_301 40
		sel_302 8
	)
)

(instance feDesk of Feature
	(properties
		sel_20 {feDesk}
		sel_0 1
		sel_213 73
		sel_214 560
		sel_301 40
		sel_302 4
	)
)

(instance sEgoEnter of Script
	(properties
		sel_20 {sEgoEnter}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(= sel_136 2)
			)
			(1
				(gEgo sel_312: PolyPath 20 170 self)
			)
			(2
				(xWestDoor sel_360:)
				(= sel_139 60)
			)
			(3
				(proc0_5 gEgo deadWatney)
				(global2 sel_146: sDeadWatney)
			)
		)
	)
)

(instance sEnterTunnel of Script
	(properties
		sel_20 {sEnterTunnel}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(secretDoor sel_110:)
				(= sel_136 2)
			)
			(1 (= sel_137 3))
			(2
				(gEgo sel_1: 306 sel_0: 147 sel_63: 5 sel_253: 180)
				(sFX sel_40: 721 sel_99: 5 sel_155: 1 sel_39:)
				(secretDoor sel_110: sel_161: End self)
			)
			(3
				(sFX sel_167:)
				(gEgo sel_63: -1 sel_312: MoveTo 303 177 self)
			)
			(4
				(gEgo sel_312: PolyPath 265 180 self)
				(sFX sel_40: 721 sel_99: 5 sel_155: 1 sel_39:)
				(secretDoor sel_161: Beg self)
			)
			(5 0)
			(6
				(gEgo sel_161: StopWalk -1)
				(proc0_5 gEgo deadWatney)
				(= sel_137 2)
			)
			(7
				(secretDoor sel_313:)
				(sFX sel_167:)
				(global2 sel_146: sDeadWatney)
				(self sel_111:)
			)
		)
	)
)

(instance sDeadWatney of Script
	(properties
		sel_20 {sDeadWatney}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gSel_561 sel_119: 102)
				(gGame sel_197: 1 1)
				(if (proc0_2 66)
					(gGameMusic2 sel_168: 1)
					(= local0 1)
					(fooSound sel_40: 6 sel_3: -1 sel_99: 1 sel_39:)
					(= sel_136 1)
				else
					(proc0_3 66)
					(global2 sel_408: 465 sel_417: 465)
					(sFX sel_40: 84 sel_99: 5 sel_3: 1 sel_39:)
					(wrapMusic sel_110: -1 2 6)
					(= local1 1)
					(= sel_139 180)
				)
			)
			(1
				(gSel_563 sel_119: 111 sel_119: 81 sel_125:)
				(gGame sel_588:)
				(self sel_146: sCUDeadWatney self)
			)
			(2
				(fooSound sel_170: 0 12 30 1)
				(if local1 (wrapMusic sel_111: 1))
				(if local0 (gGameMusic2 sel_168: 0))
				(proc0_8 0)
				(global2 sel_399: 560)
			)
		)
	)
)

(instance sCUDeadWatney of Script
	(properties
		sel_20 {sCUDeadWatney}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(= theGSel_561 gSel_561)
				(gSel_561 sel_119: 111 sel_119: 81)
				(theGSel_561 sel_119: 102)
				(global2 sel_408: 565)
				(DrawPic 565)
				(Animate (theGSel_561 sel_24?) 0)
				(global2 sel_214: 560)
				(= theGLb2DoVerbCode gLb2DoVerbCode)
				(= gLb2DoVerbCode exitDoVerbCode)
				(proc0_8 1)
				(gLb2WH sel_129: self)
				(bloodDrip sel_110: sel_244: 12 sel_161: Fwd)
				(feCpBlood sel_110:)
				(feQuills sel_110:)
				(fePorcupine sel_110:)
				(feHead sel_110:)
				(feHandLeft sel_110:)
				(feHandRight sel_110:)
				(feIntercom sel_110:)
				(feClockBroken sel_110:)
				(feCalendar sel_110:)
				(feBody sel_110:)
				(feDrawerBig sel_110:)
				(feDrawerTop sel_110:)
				(feDesk sel_110:)
			)
			(1
				(if (global2 sel_365:) ((global2 sel_365:) sel_111: 0))
				(gSel_561 sel_119: 111)
				(= gSel_561 theGSel_561)
				(gLb2WH sel_81: self)
				(gIconBar sel_177: 7)
				(= gLb2DoVerbCode theGLb2DoVerbCode)
				(self sel_111:)
			)
		)
	)
)

(instance inFeCpBlood of Inset
	(properties
		sel_20 {inFeCpBlood}
		sel_2 563
		sel_4 2
		sel_1 89
		sel_0 85
		sel_570 1
		sel_214 560
		sel_213 74
	)
	
	(method (sel_300 param1)
		(switch param1
			(13 (sCUDeadWatney sel_145:))
			(else 
				(super sel_300: param1 &rest)
			)
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

(instance exitDoVerbCode of Code
	(properties
		sel_20 {exitDoVerbCode}
	)
	
	(method (sel_57 param1 param2)
		(if (== param1 13)
			(sCUDeadWatney sel_145:)
		else
			(proc0_6 param2 param1)
		)
	)
)

(instance xWestDoor of Door
	(properties
		sel_20 {xWestDoor}
		sel_1 17
		sel_0 148
		sel_213 36
		sel_301 40
		sel_303 14
		sel_304 160
		sel_2 560
		sel_3 1
		sel_60 7
		sel_14 16
		sel_589 550
		sel_596 0
		sel_597 4
		sel_598 145
	)
)
