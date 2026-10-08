;;; Sierra Script 1.0 - (do not remove this comment)
(script# 435)
(include sci.sh)
(use Main)
(use LBRoom)
(use Inset)
(use PolyPath)
(use CueObj)
(use n958)
(use Sound)
(use View)
(use Obj)

(public
	rm435 0
)

(local
	local0
)
(instance rm435 of LBRoom
	(properties
		sel_20 {rm435}
		sel_28 -32758
	)
	
	(method (sel_110)
		(self sel_408: (if (proc0_2 72) 436 else 430))
		(proc958_0 128 431 430)
		(proc958_0 129 436 780)
		(proc958_0 132 90 6 2)
		(if (== global123 5)
			(self sel_414: 94)
		else
			(WrapMusic sel_168: 1)
			(self sel_414: 90)
		)
		(gEgo sel_55: 180)
		(super sel_110:)
		(if (not (proc0_2 72))
			(gEgo
				sel_110:
				sel_585: (if (== global123 5) 426 else 831)
				sel_320: 125
			)
			(switch gGSel_40
				(440
					(gEgo sel_1: 51 sel_0: 121)
				)
				(480
					(gEgo sel_1: 114 sel_0: 112)
				)
				(420
					(gEgo sel_1: 319 sel_0: 125)
				)
			)
			(gGame sel_87: 1 143)
			(eastDoor sel_110:)
			(eastDoor2 sel_110:)
			(westDoor sel_110:)
			(westDoor2 sel_110:)
			(wireEnd sel_110:)
			(skewer sel_110: sel_313:)
		)
		(global2 sel_146: sRunIt)
	)
	
	(method (sel_111)
		(if local0 (wrapMusic sel_111: 1))
		(screamAndLook sel_111:)
		(if (< global123 5) (WrapMusic sel_168: 0))
		(super sel_111:)
	)
	
	(method (sel_403)
		(if (== global123 5)
			(self sel_422: 0)
			((ScriptID 94 1) sel_162: (ScriptID 94 1) 2)
			(global2 sel_399: 430)
		)
	)
)

(instance sEnter of Script
	(properties
		sel_20 {sEnter}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(= sel_136 1)
			)
			(1
				(if (== gGSel_40 420)
					(gEgo sel_312: PolyPath 300 133 self)
				else
					(gEgo sel_312: PolyPath 100 133 self)
				)
			)
			(2 (self sel_111:))
		)
	)
)

(instance sRunIt of Script
	(properties
		sel_20 {sRunIt}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(if (proc0_2 72)
					(self sel_144: 4)
				else
					(self sel_146: sEnter self)
				)
			)
			(1
				(gEgo
					sel_312: PolyPath (gEgo sel_1?) (+ (gEgo sel_0?) 10) self
				)
			)
			(2
				(gEgo sel_102:)
				(eastDoor sel_111:)
				(eastDoor2 sel_111:)
				(westDoor sel_111:)
				(westDoor2 sel_111:)
				(wireEnd sel_111:)
				(skewer sel_111:)
				(global2 sel_408: 465 sel_417: 465)
				(= sel_136 1)
			)
			(3
				(wrapMusic sel_110: -1 2 6)
				(gGameMusic2 sel_40: 83 sel_99: 5 sel_3: 1 sel_39:)
				(= local0 1)
				(= sel_137 3)
			)
			(4
				(if (and (proc0_2 72) (!= global123 5))
					(screamAndLook sel_40: 6 sel_3: -1 sel_99: 1 sel_39:)
				else
					(proc0_3 72)
					(proc0_3 143)
				)
				(sel_42 sel_422: inZiggyDead self)
			)
			(5 (global2 sel_399: 430))
		)
	)
)

(instance wireEnd2 of View
	(properties
		sel_20 {wireEnd2}
		sel_1 33
		sel_0 41
		sel_213 9
		sel_2 431
		sel_3 4
		sel_60 13
		sel_14 16
	)
	
	(method (sel_307)
	)
	
	(method (sel_300 param1)
		(switch param1
			(21
				(if (proc0_2 44)
					(super sel_300: param1 &rest)
				else
					(proc0_3 63)
					(inZiggyDead sel_111:)
				)
			)
			(8
				(inZiggyDead sel_422: inWire)
			)
			(13
				(inZiggyDead sel_300: param1)
			)
			(else 
				(super sel_300: param1 &rest)
			)
		)
	)
)

(instance neck of Feature
	(properties
		sel_20 {neck}
		sel_1 1
		sel_0 1
		sel_213 5
		sel_302 16384
	)
	
	(method (sel_307)
	)
	
	(method (sel_300 param1)
		(switch param1
			(13
				(inZiggyDead sel_300: param1)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance jacket of Feature
	(properties
		sel_20 {jacket}
		sel_1 1
		sel_0 1
		sel_213 3
		sel_302 128
	)
	
	(method (sel_307)
	)
	
	(method (sel_300 param1)
		(switch param1
			(13
				(inZiggyDead sel_300: param1)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance pants of Feature
	(properties
		sel_20 {pants}
		sel_1 1
		sel_0 1
		sel_213 6
		sel_302 256
	)
	
	(method (sel_307)
	)
	
	(method (sel_300 param1)
		(switch param1
			(13
				(inZiggyDead sel_300: param1)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance ptero of Feature
	(properties
		sel_20 {ptero}
		sel_1 1
		sel_0 1
		sel_213 2
		sel_302 2
	)
	
	(method (sel_307)
	)
	
	(method (sel_300 param1)
		(switch param1
			(13
				(inZiggyDead sel_300: param1)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance wire1 of Feature
	(properties
		sel_20 {wire1}
		sel_1 1
		sel_0 1
		sel_213 8
		sel_302 4
	)
	
	(method (sel_307)
	)
	
	(method (sel_300 param1)
		(switch param1
			(21
				(if (proc0_2 44)
					(super sel_300: param1 &rest)
				else
					(proc0_3 63)
					(inZiggyDead sel_111:)
				)
			)
			(8
				(inZiggyDead sel_422: inWire)
			)
			(13
				(inZiggyDead sel_300: param1)
			)
			(else 
				(super sel_300: param1 &rest)
			)
		)
	)
)

(instance wire2 of Feature
	(properties
		sel_20 {wire2}
		sel_1 1
		sel_0 1
		sel_213 9
		sel_302 8
	)
	
	(method (sel_307)
	)
	
	(method (sel_300 param1)
		(switch param1
			(13
				(inZiggyDead sel_300: param1)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance wire3 of Feature
	(properties
		sel_20 {wire3}
		sel_1 1
		sel_0 1
		sel_213 10
		sel_302 16
	)
	
	(method (sel_307)
	)
	
	(method (sel_300 param1)
		(switch param1
			(13
				(inZiggyDead sel_300: param1)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance lHand of Feature
	(properties
		sel_20 {lHand}
		sel_1 1
		sel_0 1
		sel_213 4
		sel_302 32
	)
	
	(method (sel_307)
	)
	
	(method (sel_300 param1)
		(switch param1
			(13
				(inZiggyDead sel_300: param1)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance rHand of Feature
	(properties
		sel_20 {rHand}
		sel_1 1
		sel_0 1
		sel_213 7
		sel_302 64
	)
	
	(method (sel_307)
	)
	
	(method (sel_300 param1)
		(switch param1
			(13
				(inZiggyDead sel_300: param1)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance blood of Feature
	(properties
		sel_20 {blood}
		sel_1 1
		sel_0 1
		sel_213 1
		sel_302 512
	)
	
	(method (sel_307)
	)
	
	(method (sel_300 param1)
		(switch param1
			(13
				(inZiggyDead sel_300: param1)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance wound of Feature
	(properties
		sel_20 {wound}
		sel_1 1
		sel_0 1
		sel_213 11
		sel_302 1024
	)
	
	(method (sel_307)
	)
	
	(method (sel_300 param1)
		(switch param1
			(13
				(inZiggyDead sel_300: param1)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance inWire of Inset
	(properties
		sel_20 {inWire}
		sel_2 431
		sel_3 2
		sel_1 8
		sel_0 42
		sel_570 1
		sel_213 8
	)
	
	(method (sel_300 param1)
		(switch param1
			(21
				(if (proc0_2 44)
					(super sel_300: param1 &rest)
				else
					(proc0_3 63)
					(self sel_111:)
					(inZiggyDead sel_111:)
				)
			)
			(else 
				(super sel_300: param1 &rest)
			)
		)
	)
)

(instance inZiggyDead of Inset
	(properties
		sel_20 {inZiggyDead}
		sel_408 436
		sel_28 -32758
		sel_560 1
	)
	
	(method (sel_110)
		(super sel_110: &rest)
		(proc0_3 72)
		(proc0_3 143)
		(global2 sel_408: 780)
		(gGame sel_588:)
		(proc0_8 1)
		(neck sel_110:)
		(jacket sel_110:)
		(pants sel_110:)
		(ptero sel_110:)
		(wire1 sel_110:)
		(wire2 sel_110:)
		(wire3 sel_110:)
		(lHand sel_110:)
		(rHand sel_110:)
		(blood sel_110:)
		(wound sel_110:)
		(if (not (proc0_2 44)) (wireEnd2 sel_110:))
		(= sel_28 100)
	)
	
	(method (sel_111)
		(= sel_28 -32758)
		(screamAndLook sel_170: 0 12 30 1)
		(proc0_8 0)
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

(instance westDoor2 of View
	(properties
		sel_20 {westDoor2}
		sel_1 74
		sel_0 66
		sel_2 432
		sel_3 1
		sel_4 4
		sel_14 16384
	)
)

(instance eastDoor2 of View
	(properties
		sel_20 {eastDoor2}
		sel_1 312
		sel_0 68
		sel_2 432
		sel_3 3
		sel_4 9
		sel_60 9
		sel_14 16400
	)
)

(instance eastDoor of View
	(properties
		sel_20 {eastDoor}
		sel_1 292
		sel_0 68
		sel_2 432
		sel_3 2
		sel_4 9
		sel_14 16384
	)
)

(instance westDoor of View
	(properties
		sel_20 {westDoor}
		sel_1 53
		sel_0 66
		sel_2 432
		sel_4 4
		sel_60 9
		sel_14 16400
	)
)

(instance skewer of View
	(properties
		sel_20 {skewer}
		sel_1 3
		sel_0 189
		sel_82 89
		sel_2 430
		sel_3 1
		sel_60 15
		sel_14 20496
	)
)

(instance wireEnd of View
	(properties
		sel_20 {wireEnd}
		sel_1 21
		sel_0 130
		sel_2 431
		sel_3 4
		sel_4 1
		sel_60 15
		sel_14 16400
	)
)

(instance wrapMusic of WrapMusic
	(properties
		sel_20 {wrapMusic}
	)
	
	(method (sel_110)
		(= sel_608 screamAndLook)
		(super sel_110: &rest)
	)
)

(instance screamAndLook of Sound
	(properties
		sel_20 {screamAndLook}
	)
)
