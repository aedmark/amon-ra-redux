;;; Sierra Script 1.0 - (do not remove this comment)
(script# 561)
(include sci.sh)
(use Main)
(use Inset)
(use PolyPath)
(use CueObj)
(use StopWalk)
(use Sound)
(use Cycle)
(use View)
(use Obj)

(public
	safePicture 0
	safeDoor 1
)

(local
	local0
	local1
	local2
	local3
	dialNumberSel_4
	[theDialNumberSel_4 4]
)
(instance safePicture of Prop
	(properties
		sel_20 {safePicture}
		sel_1 82
		sel_0 100
		sel_213 38
		sel_214 561
		sel_303 93
		sel_304 149
		sel_2 564
		sel_3 1
		sel_60 6
		sel_14 16
	)
	
	(method (sel_110)
		(super sel_110: &rest)
		(safe sel_110: sel_313:)
		(safeDoor sel_110: sel_313:)
		(self sel_300: 4)
	)
	
	(method (sel_111)
		(sFX sel_111:)
		(safe sel_111:)
		(safeDoor sel_111:)
		(super sel_111:)
	)
	
	(method (sel_300 param1)
		(switch param1
			(4
				(cond 
					((== (self sel_4?) 0)
						(sFX sel_40: 44 sel_99: 5 sel_155: 1 sel_39:)
						(self sel_161: End)
					)
					((== (safeDoor sel_4?) 0)
						(sFX sel_40: 45 sel_99: 5 sel_155: 1 sel_39:)
						(self sel_161: Beg)
					)
				)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance safeDoor of Prop
	(properties
		sel_20 {safeDoor}
		sel_1 76
		sel_0 95
		sel_213 40
		sel_214 561
		sel_303 93
		sel_304 149
		sel_2 564
		sel_3 2
		sel_60 5
		sel_14 16
	)
	
	(method (sel_307)
	)
	
	(method (sel_300 param1)
		(switch param1
			(1 (global2 sel_422: inDial))
			(8 (global2 sel_422: inDial))
			(4
				(gEgo sel_253: 270)
				(++ local3)
				(cond 
					(local0
						(if (== (self sel_4?) 0)
							(= local3 0)
							(sFX sel_40: 560 sel_99: 5 sel_155: 1 sel_39:)
							(self sel_63: 7 sel_161: End)
							(= local1 1)
						else
							(= local0 0)
							(self sel_146: sCloseSafe)
						)
					)
					((< local3 3) (global2 sel_422: inDial))
					(else (self sel_146: sHeimlichEnters))
				)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance inDial of Inset
	(properties
		sel_20 {inDial}
		sel_2 564
		sel_3 4
		sel_1 53
		sel_0 33
		sel_570 1
		sel_214 561
	)
	
	(method (sel_110)
		(super sel_110: &rest)
		(dialNumber sel_110:)
		(zero sel_110:)
		(one sel_110:)
		(two sel_110:)
		(three sel_110:)
		(four sel_110:)
		(five sel_110:)
		(six sel_110:)
		(seven sel_110:)
		(eight sel_110:)
		(nine sel_110:)
		(safeDoor sel_313:)
		(safePicture sel_313:)
		(gEgo sel_313:)
		(= local2 0)
		(= [theDialNumberSel_4 0] -1)
		(= [theDialNumberSel_4 1] -1)
		(= [theDialNumberSel_4 2] -1)
		(= [theDialNumberSel_4 3] -1)
	)
	
	(method (sel_111)
		(dialNumber sel_111:)
		(zero sel_111:)
		(one sel_111:)
		(two sel_111:)
		(three sel_111:)
		(four sel_111:)
		(five sel_111:)
		(six sel_111:)
		(seven sel_111:)
		(eight sel_111:)
		(nine sel_111:)
		(safeDoor sel_315:)
		(safePicture sel_315:)
		(gEgo sel_315:)
		(super sel_111:)
	)
)

(instance dialNumber of Prop
	(properties
		sel_20 {dialNumber}
		sel_1 61
		sel_0 39
		sel_213 78
		sel_214 561
		sel_2 564
		sel_3 5
		sel_60 15
		sel_14 16
		sel_244 18
	)
	
	(method (sel_307)
	)
)

(instance safe of View
	(properties
		sel_20 {safe}
		sel_1 55
		sel_0 70
		sel_213 39
		sel_214 561
		sel_303 93
		sel_304 149
		sel_2 564
	)
	
	(method (sel_307)
	)
	
	(method (sel_300 param1)
		(switch param1
			(1
				(if local1
					(global2 sel_422: inDiary)
				else
					(gLb2Messager sel_295: 39 1 0 0 0 561)
				)
			)
			(8
				(if local1
					(global2 sel_422: inDiary)
				else
					(gLb2Messager sel_295: 39 1 0 0 0 561)
				)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance inDiary of Inset
	(properties
		sel_20 {inDiary}
		sel_2 564
		sel_3 3
		sel_1 53
		sel_0 45
		sel_570 1
		sel_214 561
		sel_213 60
	)
	
	(method (sel_300 param1)
		(switch param1
			(1
				(gGame sel_87: 1 174)
				((ScriptID 21 0) sel_57: 1030)
				(gLb2Messager sel_295: 60 1 0 0 0 561)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance sTurnTumbler of Script
	(properties
		sel_20 {sTurnTumbler}
	)
	
	(method (sel_144 theSel_29 &tmp temp0)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(= temp0 (if (mod local2 2) -1 else 1))
				(sFX sel_40: 562 sel_99: 1 sel_39: sel_155: -1)
				(dialNumber
					sel_161: CT (mod (+ dialNumberSel_4 sel_141) 10) temp0 self
				)
			)
			(1
				(= dialNumberSel_4 (dialNumber sel_4?))
				(if (< (++ local2) 5)
					(= [theDialNumberSel_4 (- local2 1)] dialNumberSel_4)
				)
				(if (== local2 4)
					(if
						(and
							(== [theDialNumberSel_4 0] 0)
							(== [theDialNumberSel_4 1] 5)
							(== [theDialNumberSel_4 2] 2)
							(== [theDialNumberSel_4 3] 7)
						)
						(= local0 1)
						(sFX sel_40: 558 sel_99: 1 sel_155: 1 sel_39:)
					else
						(= local0 0)
						(sFX sel_167:)
					)
					(inDial sel_111:)
					(dialNumber sel_111:)
				else
					(sFX sel_167:)
				)
				(gGame sel_588:)
				(self sel_111:)
			)
		)
	)
)

(instance sCloseSafe of Script
	(properties
		sel_20 {sCloseSafe}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(safeDoor sel_63: 5 sel_161: Beg self)
			)
			(1
				(sFX sel_40: 561 sel_99: 5 sel_39: sel_155: 1)
				(= local1 0)
				(self sel_111:)
			)
		)
	)
)

(instance sHeimlichEnters of Script
	(properties
		sel_20 {sHeimlichEnters}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(gGameMusic2 sel_170:)
				((ScriptID 560 4)
					sel_590: 0
					sel_600: 2
					sel_143: self
					sel_189:
				)
			)
			(1
				(gGameMusic2 sel_40: 19 sel_3: -1 sel_99: 1 sel_39:)
				(gGame sel_587:)
				(= sel_139 60)
			)
			(2
				(proc0_5 gEgo (ScriptID 560 4))
				(= sel_139 60)
			)
			(3
				((ScriptID 32 0)
					sel_110:
					sel_155: 0
					sel_156: 5
					sel_153: 0 146
					sel_63: 10
					sel_620: 560
					sel_2: 814
					sel_161: Walk
					sel_312: MoveTo 11 148 self
				)
			)
			(4
				((ScriptID 32 0) sel_312: PolyPath 64 163 self)
			)
			(5
				(proc0_5 gEgo (ScriptID 32 0))
				((ScriptID 32 0) sel_63: -1 sel_161: StopWalk -1)
				(= sel_136 1)
			)
			(6
				(proc0_5 (ScriptID 32 0) gEgo)
				(= sel_139 60)
			)
			(7
				(gLb2Messager sel_295: 3 0 87 0 self 1889)
			)
			(8
				(gEgo sel_312: PolyPath 10 175 self)
			)
			(9
				(proc0_5 (ScriptID 32 0) gEgo)
				(gEgo sel_312: PolyPath 4 145 self)
			)
			(10
				(proc0_3 97)
				(gGameMusic2 sel_170: self)
			)
			(11
				(gGame sel_588:)
				(global2 sel_399: 550)
				(self sel_111:)
			)
		)
	)
)

(class DialFeature of Feature
	(properties
		sel_20 {DialFeature}
		sel_1 0
		sel_0 0
		sel_82 0
		sel_55 0
		sel_213 0
		sel_214 -1
		sel_6 0
		sel_7 0
		sel_8 0
		sel_9 0
		sel_301 26505
		sel_299 0
		sel_302 26505
		sel_303 0
		sel_304 0
		sel_305 0
		sel_306 0
		sel_676 0
	)
	
	(method (sel_307)
	)
)

(instance zero of DialFeature
	(properties
		sel_20 {zero}
		sel_0 100
		sel_6 38
		sel_7 97
		sel_8 50
		sel_9 110
	)
	
	(method (sel_300 param1)
		(switch param1
			(4
				(dialNumber sel_146: sTurnTumbler 0 sel_676)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance one of DialFeature
	(properties
		sel_20 {one}
		sel_0 100
		sel_6 45
		sel_7 120
		sel_8 57
		sel_9 135
		sel_676 1
	)
	
	(method (sel_300 param1)
		(switch param1
			(4
				(dialNumber sel_146: sTurnTumbler 0 sel_676)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance two of DialFeature
	(properties
		sel_20 {two}
		sel_0 100
		sel_6 63
		sel_7 133
		sel_8 75
		sel_9 149
		sel_676 2
	)
	
	(method (sel_300 param1)
		(switch param1
			(4
				(dialNumber sel_146: sTurnTumbler 0 sel_676)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance three of DialFeature
	(properties
		sel_20 {three}
		sel_0 100
		sel_6 87
		sel_7 135
		sel_8 100
		sel_9 150
		sel_676 3
	)
	
	(method (sel_300 param1)
		(switch param1
			(4
				(dialNumber sel_146: sTurnTumbler 0 sel_676)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance four of DialFeature
	(properties
		sel_20 {four}
		sel_0 100
		sel_6 103
		sel_7 123
		sel_8 116
		sel_9 135
		sel_676 4
	)
	
	(method (sel_300 param1)
		(switch param1
			(4
				(dialNumber sel_146: sTurnTumbler 0 sel_676)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance five of DialFeature
	(properties
		sel_20 {five}
		sel_0 100
		sel_6 109
		sel_7 97
		sel_8 123
		sel_9 111
		sel_676 5
	)
	
	(method (sel_300 param1)
		(switch param1
			(4
				(dialNumber sel_146: sTurnTumbler 0 sel_676)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance six of DialFeature
	(properties
		sel_20 {six}
		sel_0 100
		sel_6 104
		sel_7 76
		sel_8 120
		sel_9 90
		sel_676 6
	)
	
	(method (sel_300 param1)
		(switch param1
			(4
				(dialNumber sel_146: sTurnTumbler 0 sel_676)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance seven of DialFeature
	(properties
		sel_20 {seven}
		sel_0 100
		sel_6 86
		sel_7 58
		sel_8 101
		sel_9 74
		sel_676 7
	)
	
	(method (sel_300 param1)
		(switch param1
			(4
				(dialNumber sel_146: sTurnTumbler 0 sel_676)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance eight of DialFeature
	(properties
		sel_20 {eight}
		sel_0 100
		sel_6 54
		sel_7 58
		sel_8 75
		sel_9 75
		sel_676 8
	)
	
	(method (sel_300 param1)
		(switch param1
			(4
				(dialNumber sel_146: sTurnTumbler 0 sel_676)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance nine of DialFeature
	(properties
		sel_20 {nine}
		sel_0 100
		sel_6 43
		sel_7 74
		sel_8 58
		sel_9 91
		sel_676 9
	)
	
	(method (sel_300 param1)
		(switch param1
			(4
				(dialNumber sel_146: sTurnTumbler 0 sel_676)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance sFX of Sound
	(properties
		sel_20 {sFX}
		sel_99 1
	)
)
