;;; Sierra Script 1.0 - (do not remove this comment)
(script# 443)
(include sci.sh)
(use Main)
(use MuseumRgn)
(use Inset)
(use Scaler)
(use CueObj)
(use Sound)
(use Cycle)
(use View)
(use Obj)

(public
	boot 0
	blood 1
	inBoot 2
	inPippin 3
	armorPippin 4
)

(local
	local0
)
(instance sFindPippin of Script
	(properties
		sel_20 {sFindPippin}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(= sel_136 1)
			)
			(1
				(gEgo
					sel_2: 442
					sel_3: 0
					sel_4: 0
					sel_153: 129 162
					sel_161: CT 5 1 self
				)
			)
			(2
				(noise sel_40: 440 sel_39:)
				(gEgo sel_161: End self)
			)
			(3 (= sel_137 3))
			(4
				(gGame sel_588:)
				(= local0 1)
				(gEgo
					sel_3: 6
					sel_585: (if (== global123 5) 426 else 831)
					sel_320: Scaler 155 0 190 90
				)
				(global2 sel_422: inPippin self)
			)
			(5 (self sel_111:))
		)
	)
)

(instance sGetBoot of Script
	(properties
		sel_20 {sGetBoot}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(= sel_136 1)
			)
			(1
				(gEgo sel_2: 440 sel_155: 6 sel_244: 16 sel_161: End self)
			)
			(2
				(boot sel_111:)
				(gEgo sel_350: 12)
				((ScriptID 21 0) sel_57: 781)
				(gEgo sel_161: Beg self)
			)
			(3
				(gGame sel_87: 1 150)
				(= sel_136 1)
			)
			(4
				(gEgo
					sel_3: 5
					sel_153: (+ (gEgo sel_1?) 2) (gEgo sel_0?)
					sel_585: (if (== global123 5) 426 else 831)
				)
				(gGame sel_588:)
				(self sel_111:)
			)
		)
	)
)

(instance boot of View
	(properties
		sel_20 {boot}
		sel_1 85
		sel_0 169
		sel_303 100
		sel_304 162
		sel_2 440
	)
	
	(method (sel_300 param1)
		(switch param1
			(1
				(gGame sel_87: 1 150)
				(global2 sel_422: inBoot)
			)
			(4 (global2 sel_146: sGetBoot))
			(8
				(gGame sel_87: 1 150)
				(global2 sel_422: inBoot)
			)
			(else 
				(super sel_300: param1 &rest)
			)
		)
	)
)

(instance blood of View
	(properties
		sel_20 {blood}
		sel_1 89
		sel_0 172
		sel_213 34
		sel_303 100
		sel_304 162
		sel_2 440
		sel_3 1
		sel_14 16384
	)
)

(instance inBoot of Inset
	(properties
		sel_20 {inBoot}
		sel_2 440
		sel_4 1
		sel_1 57
		sel_0 154
		sel_60 15
		sel_570 1
		sel_214 15
		sel_213 40
	)
	
	(method (sel_300 param1)
		(switch param1
			(4
				(global2 sel_146: sGetBoot)
				(inBoot sel_111:)
			)
			(else 
				(super sel_300: param1 &rest)
			)
		)
	)
)

(instance inPippin of Inset
	(properties
		sel_20 {inPippin}
		sel_2 442
		sel_3 1
		sel_1 100
		sel_0 40
		sel_60 15
		sel_570 1
		sel_213 11
	)
	
	(method (sel_111)
		(noise sel_111:)
		(super sel_111:)
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
		sel_302 8192
		sel_303 128
		sel_304 165
	)
	
	(method (sel_300 param1)
		(return
			(switch param1
				(1
					(cond 
						(local0
							(if (MuseumRgn sel_646:)
								(global2 sel_422: inPippin)
							else
								(return 1)
							)
						)
						((>= global123 3) (gLb2Messager sel_295: 10 1 1))
						(else (gLb2Messager sel_295: 10 1 2))
					)
				)
				(8
					(if (>= global123 3)
						(gLb2Messager sel_295: 10 8 1)
					else
						(gLb2Messager sel_295: 10 8 2)
					)
				)
				(4
					(cond 
						(local0 (global2 sel_422: inPippin))
						((>= global123 3)
							(if (not (== (gEgo sel_2?) 443))
								(if (MuseumRgn sel_646:)
									(global2 sel_146: sFindPippin)
								else
									(return 1)
								)
							else
								(super sel_300: param1)
							)
						)
						(else (gLb2Messager sel_295: 10 4 2))
					)
				)
				(else  (super sel_300: param1))
			)
		)
	)
)

(instance noise of Sound
	(properties
		sel_20 {noise}
		sel_99 1
	)
)
