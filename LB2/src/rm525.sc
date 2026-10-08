;;; Sierra Script 1.0 - (do not remove this comment)
(script# 525)
(include sci.sh)
(use Main)
(use LBRoom)
(use Inset)
(use CueObj)
(use n958)
(use Timer)
(use Sound)
(use View)
(use Obj)

(public
	rm525 0
)

(local
	theGLb2DoVerbCode
)
(procedure (localproc_0374)
	(proc0_8 1)
	(if (not (gEgo sel_238: 31)) (grapes sel_110:))
	(feIntercom sel_110:)
	(feDocBottom sel_110:)
	(feDocTop sel_110:)
	(feDesk sel_110:)
	(feDocDesk sel_110:)
	(feDocLeft sel_110:)
	(feBody sel_110:)
	(feAnkle sel_110:)
	(feLeg sel_110:)
	(feHands sel_110:)
	(feFace sel_110:)
	(gGame sel_588:)
)

(instance rm525 of LBRoom
	(properties
		sel_20 {rm525}
		sel_408 525
	)
	
	(method (sel_110)
		(proc958_0 128 520 523 524 525 526)
		(proc958_0 129 556 525)
		(proc958_0 132 520 524 4 6 85)
		(self sel_414: 90)
		(= theGLb2DoVerbCode gLb2DoVerbCode)
		(= gLb2DoVerbCode exitDoVerbCode)
		(proc0_3 165)
		(if (proc0_3 69)
			(= sel_408 525)
			(gSel_608 sel_40: 6 sel_3: -1 sel_99: 1 sel_39:)
			(localproc_0374)
		else
			(= sel_408 556)
			(wrapMusic sel_110: -1 4 6)
			(sFX sel_40: 85 sel_99: 5 sel_3: 1 sel_39:)
			((Timer sel_109:) sel_162: self 3)
		)
		(super sel_110:)
	)
	
	(method (sel_300 param1)
		(switch param1
			(13
				(proc0_8 0)
				(self sel_399: 520)
			)
			(else  (super sel_300: param1))
		)
	)
	
	(method (sel_145)
		(self sel_417: (= sel_408 525))
		(localproc_0374)
	)
	
	(method (sel_399 param1)
		(= gLb2DoVerbCode theGLb2DoVerbCode)
		(if sel_365 (sel_365 sel_111:))
		(gIconBar sel_177: 7)
		(if (gSounds sel_122: wrapSong) (wrapMusic sel_111: 1))
		(super sel_399: param1)
	)
)

(instance grapes of View
	(properties
		sel_20 {grapes}
		sel_1 224
		sel_0 154
		sel_213 15
		sel_2 526
		sel_4 1
	)
	
	(method (sel_300 param1)
		(switch param1
			(1 (global2 sel_422: inGrapes))
			(8 (global2 sel_422: inGrapes))
			(4 (global2 sel_422: inGrapes))
			(else 
				(super sel_300: param1 &rest)
			)
		)
	)
)

(instance feIntercom of Feature
	(properties
		sel_20 {feIntercom}
		sel_0 1
		sel_213 10
		sel_301 40
		sel_302 4
	)
)

(instance feDocBottom of Feature
	(properties
		sel_20 {feDocBottom}
		sel_0 1
		sel_213 4
		sel_301 40
		sel_302 16
	)
)

(instance feDocTop of Feature
	(properties
		sel_20 {feDocTop}
		sel_0 1
		sel_213 7
		sel_301 40
		sel_302 32
	)
)

(instance feDesk of Feature
	(properties
		sel_20 {feDesk}
		sel_0 1
		sel_213 3
		sel_301 40
		sel_302 128
	)
)

(instance feDocDesk of Feature
	(properties
		sel_20 {feDocDesk}
		sel_0 1
		sel_213 5
		sel_301 40
		sel_302 256
	)
)

(instance feDocLeft of Feature
	(properties
		sel_20 {feDocLeft}
		sel_0 1
		sel_213 6
		sel_301 40
		sel_302 512
	)
)

(instance feBody of Feature
	(properties
		sel_20 {feBody}
		sel_0 1
		sel_213 2
		sel_301 40
		sel_302 1024
	)
	
	(method (sel_300 param1)
		(switch param1
			(8
				(if (not (gEgo sel_238: 13))
					(global2 sel_422: inSmellingSalts)
				)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance feAnkle of Feature
	(properties
		sel_20 {feAnkle}
		sel_0 1
		sel_213 1
		sel_301 40
		sel_302 2048
	)
	
	(method (sel_300 param1)
		(switch param1
			(8 (global2 sel_422: inFeAnkle))
			(else  (super sel_300: param1))
		)
	)
)

(instance feLeg of Feature
	(properties
		sel_20 {feLeg}
		sel_0 1
		sel_213 11
		sel_301 40
		sel_302 4096
	)
	
	(method (sel_300 param1)
		(switch param1
			(8 (global2 sel_422: inFeAnkle))
			(else  (super sel_300: param1))
		)
	)
)

(instance feHands of Feature
	(properties
		sel_20 {feHands}
		sel_0 1
		sel_213 9
		sel_301 40
		sel_302 16384
	)
)

(instance feFace of Feature
	(properties
		sel_20 {feFace}
		sel_0 1
		sel_213 8
		sel_301 40
		sel_302 -32768
	)
)

(instance inGrapes of Inset
	(properties
		sel_20 {inGrapes}
		sel_2 526
		sel_1 210
		sel_0 144
		sel_570 1
		sel_213 12
	)
	
	(method (sel_300 param1)
		(switch param1
			(13
				(proc0_8 0)
				(global2 sel_399: 520)
			)
			(4
				(gGame sel_87: 1 165)
				(gEgo sel_350: 31)
				((ScriptID 21 0) sel_57: 800)
				((ScriptID 22 0) sel_57: 16)
				(grapes sel_111:)
				(self sel_111:)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance inSmellingSalts of Inset
	(properties
		sel_20 {inSmellingSalts}
		sel_2 526
		sel_3 1
		sel_1 121
		sel_0 41
		sel_570 1
		sel_213 14
	)
	
	(method (sel_300 param1)
		(switch param1
			(13
				(proc0_8 0)
				(global2 sel_399: 520)
			)
			(4
				(gGame sel_87: 1 166)
				(gEgo sel_350: 13)
				((ScriptID 21 0) sel_57: 782)
				(self sel_111:)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance inFeAnkle of Inset
	(properties
		sel_20 {inFeAnkle}
		sel_2 526
		sel_3 2
		sel_1 117
		sel_0 133
		sel_570 1
		sel_213 16
	)
	
	(method (sel_300 param1)
		(switch param1
			(13
				(proc0_8 0)
				(global2 sel_399: 520)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance inIntercom of Inset
	(properties
		sel_20 {inIntercom}
		sel_2 520
		sel_1 162
		sel_0 79
		sel_570 1
		sel_213 13
	)
	
	(method (sel_300 param1)
		(switch param1
			(13
				(proc0_8 0)
				(global2 sel_399: 520)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance wrapMusic of WrapMusic
	(properties
		sel_20 {wrapMusic}
	)
	
	(method (sel_110)
		(= sel_608 wrapSong)
		(super sel_110: &rest)
	)
)

(instance wrapSong of Sound
	(properties
		sel_20 {wrapSong}
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
			(proc0_8 0)
			(global2 sel_399: 520)
		else
			(proc0_6 param2 param1)
		)
	)
)
