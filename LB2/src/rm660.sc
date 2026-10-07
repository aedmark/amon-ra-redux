;;; Sierra Script 1.0 - (do not remove this comment)
(script# 660)
(include sci.sh)
(use Main)
(use LBRoom)
(use ExitFeature)
(use MuseumRgn)
(use PChase)
(use PolyPath)
(use CueObj)
(use MoveFwd)
(use n958)
(use Sound)
(use Cycle)
(use View)
(use Obj)

(public
	rm660 0
)

(local
	local0
)
(instance rm660 of LBRoom
	(properties
		sel_20 {rm660}
		sel_408 660
		sel_411 460
	)
	
	(method (sel_110)
		(proc958_0 128 660 423 661 858 424)
		(proc958_0 132 662 661 660)
		(proc958_0 130 94 2660)
		(if (== global123 5)
			(self sel_414: 94)
			(global2 sel_259: (List sel_109:))
			((ScriptID 2660 0) sel_57: (global2 sel_259?))
		else
			(self sel_414: 90)
			(MuseumRgn sel_645:)
		)
		(gEgo sel_110: sel_320: 125 sel_585: 426)
		(super sel_110:)
		(crank sel_110: sel_313:)
		(wall1 sel_110: sel_313:)
		(wall2 sel_110: sel_313:)
		(walls sel_110:)
		(floor sel_110:)
		(ceiling sel_110:)
		(trash sel_110:)
		(southExitFeature sel_110:)
		(self sel_146: sEnterElevator)
	)
	
	(method (sel_57)
		(cond 
			(sel_142)
			((proc0_1 gEgo 16) (gEgo sel_349: 3))
		)
		(super sel_57:)
	)
	
	(method (sel_111)
		(DisposeScript 2660)
		(super sel_111: &rest)
	)
	
	(method (sel_403)
		(if (== global123 5)
			(if (global2 sel_142?)
				((global2 sel_142?) sel_65: sDie)
			else
				(global2 sel_146: sDie)
			)
		)
	)
)

(instance sDie of Script
	(properties
		sel_20 {sDie}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(gSel_608 sel_40: 3 sel_99: 1 sel_3: 1 sel_39:)
				(gEgo sel_312: MoveTo 160 120 self)
			)
			(1
				(oriley
					sel_110:
					sel_320: 125
					sel_161: Walk
					sel_312: PChase gEgo 22 self
				)
			)
			(2
				(oriley sel_2: 424)
				(oriley sel_4: 0)
				(proc0_5 gEgo oriley)
				(proc0_5 oriley gEgo)
				(= sel_136 4)
			)
			(3 (oriley sel_161: End self))
			(4
				(thudSound sel_39:)
				(gEgo sel_2: 858 sel_161: End self)
			)
			(5
				(= global145 0)
				(global2 sel_399: 99)
				(self sel_111:)
			)
		)
	)
)

(instance sGoingDown of Script
	(properties
		sel_20 {sGoingDown}
	)
	
	(method (sel_57)
		(super sel_57:)
		(switch sel_29
			(5
				(gEgo
					sel_105: (+ (gEgo sel_105?) 2)
					sel_104: (- (gEgo sel_104?) 2)
				)
			)
			(6
				(gEgo
					sel_105: (- (gEgo sel_105?) 2)
					sel_104: (+ (gEgo sel_104?) 2)
				)
			)
			(10
				(gEgo
					sel_105: (- (gEgo sel_105?) 3)
					sel_104: (+ (gEgo sel_104?) 4)
				)
			)
			(11
				(gEgo
					sel_105: (+ (gEgo sel_105?) 3)
					sel_104: (- (gEgo sel_104?) 4)
				)
			)
		)
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				((ScriptID 94 1) sel_111: sel_81:)
				(gEgo sel_312: PolyPath 165 117 self)
			)
			(1
				(gEgo sel_2: 661 sel_3: 0 sel_4: 0 sel_161: CT 3 1 self)
			)
			(2
				(gEgo sel_161: End self)
				(crank sel_161: End self)
				(gGameMusic2 sel_40: 661 sel_99: 1 sel_3: 1 sel_39:)
			)
			(3
				(gSel_608 sel_40: 660 sel_99: 1 sel_3: 1 sel_39:)
			)
			(4
				(crank sel_313:)
				(gEgo sel_585: 426 sel_253: 180 sel_103: 1 sel_106: 256)
				(gGameMusic2 sel_40: 662 sel_99: 1 sel_3: -1 sel_39:)
				(wall1 sel_161: Fwd)
				(wall2 sel_161: Fwd)
				(= sel_136 1)
			)
			(5 (= sel_136 10))
			(6 (= sel_136 10))
			(7 (= sel_137 2))
			(8
				(wall1 sel_244: (+ (wall1 sel_244?) 1))
				(wall2 sel_244: (+ (wall1 sel_244?) 1))
				(= sel_137 1)
			)
			(9
				(if (< (wall1 sel_244?) 8)
					(self sel_144: 8)
				else
					(wall1 sel_161: End)
					(wall2 sel_161: End)
					(= sel_136 1)
				)
			)
			(10 (= sel_136 10))
			(11 (= sel_136 10))
			(12
				(gGameMusic2 sel_167:)
				(gGame sel_588:)
				(wall1 sel_313:)
				(wall2 sel_313:)
				(global2 sel_411: 700)
				(self sel_111:)
			)
		)
	)
)

(instance sEnterElevator of Script
	(properties
		sel_20 {sEnterElevator}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(gEgo
					sel_153: 160 200
					sel_253: 0
					sel_312: MoveFwd 80 self
				)
			)
			(1 (gEgo sel_253: 180 self))
			(2
				(gGame sel_588:)
				(self sel_111:)
			)
		)
	)
)

(instance oriley of Actor
	(properties
		sel_20 {oriley}
		sel_1 160
		sel_0 180
		sel_2 423
	)
)

(instance crank of Prop
	(properties
		sel_20 {crank}
		sel_1 189
		sel_0 80
		sel_213 1
		sel_2 661
		sel_3 1
		sel_60 15
		sel_14 16
	)
	
	(method (sel_300 param1)
		(switch param1
			(4
				(if local0
					(gLb2Messager sel_295: 1 4 4)
				else
					(global2 sel_146: sGoingDown)
					(= local0 1)
				)
			)
			(else 
				(super sel_300: param1 &rest)
			)
		)
	)
)

(instance wall1 of Prop
	(properties
		sel_20 {wall1}
		sel_1 106
		sel_0 125
		sel_2 660
		sel_244 0
	)
)

(instance wall2 of Prop
	(properties
		sel_20 {wall2}
		sel_1 217
		sel_0 125
		sel_2 660
		sel_244 0
	)
)

(instance walls of Feature
	(properties
		sel_20 {walls}
		sel_1 162
		sel_0 8
		sel_213 2
		sel_302 8
	)
)

(instance floor of Feature
	(properties
		sel_20 {floor}
		sel_1 162
		sel_0 8
		sel_213 5
		sel_302 32
	)
)

(instance ceiling of Feature
	(properties
		sel_20 {ceiling}
		sel_1 162
		sel_0 8
		sel_213 4
		sel_302 4
	)
)

(instance trash of Feature
	(properties
		sel_20 {trash}
		sel_1 6
		sel_0 60
		sel_213 3
		sel_301 40
		sel_302 2
	)
)

(instance southExitFeature of ExitFeature
	(properties
		sel_20 {southExitFeature}
		sel_6 122
		sel_7 125
		sel_8 189
		sel_9 202
		sel_33 11
		sel_583 3
		sel_213 6
	)
)

(instance thudSound of Sound
	(properties
		sel_20 {thudSound}
		sel_99 5
		sel_40 80
	)
)
